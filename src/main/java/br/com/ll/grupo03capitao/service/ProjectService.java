package br.com.ll.grupo03capitao.service;

import java.util.List;
import br.com.ll.grupo03capitao.exception.ResourceNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ll.grupo03capitao.dto.FeedbackDTO;
import br.com.ll.grupo03capitao.dto.ProjectDTO;
import br.com.ll.grupo03capitao.model.Feedback;
import br.com.ll.grupo03capitao.model.Profile;
import br.com.ll.grupo03capitao.model.Project;
import br.com.ll.grupo03capitao.repository.FeedbackRepository;
import br.com.ll.grupo03capitao.repository.ProfileRepository;
import br.com.ll.grupo03capitao.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProfileRepository profileRepository;
    private final FeedbackRepository feedbackRepository;

    public ProjectService(
            ProjectRepository projectRepository,
            ProfileRepository profileRepository,
            FeedbackRepository feedbackRepository) {

        this.projectRepository = projectRepository;
        this.profileRepository = profileRepository;
        this.feedbackRepository = feedbackRepository;
    }

    public ProjectDTO create(ProjectDTO dto) {

        Profile profile = profileRepository.findById(dto.getProfileId())
                .orElseThrow(() ->
                new ResourceNotFoundException("Perfil não encontrado"));

        Project project = new Project();

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setProfile(profile);

        Project saved = projectRepository.save(project);

        return toDTO(saved);
    }

    public Page<ProjectDTO> findAll(
            String technology,
            Pageable pageable) {

        Page<Project> projects;

        if (technology != null && !technology.isBlank()) {

            projects = projectRepository
                    .findByTechnologiesNameIgnoreCase(
                            technology,
                            pageable);

        } else {

            projects = projectRepository.findAll(pageable);
        }

        return projects.map(this::toDTO);
    }

    public ProjectDTO upvote(Long id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Projeto não encontrado"));

        project.setUpvotes(project.getUpvotes() + 1);

        return toDTO(projectRepository.save(project));
    }

    public FeedbackDTO addFeedback(
            Long id,
            FeedbackDTO dto) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Projeto não encontrado"));

        if (dto.getRating() == null ||
                dto.getRating() < 1 ||
                dto.getRating() > 5) {

            throw new IllegalArgumentException(
                    "A nota deve estar entre 1 e 5");
        }

        Feedback feedback = new Feedback();

        feedback.setRating(dto.getRating());
        feedback.setMessage(dto.getMessage());
        feedback.setProject(project);

        feedbackRepository.save(feedback);

        List<Feedback> feedbacks =
                feedbackRepository.findByProject(project);

        double average = feedbacks.stream()
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0.0);

        project.setAverageRating(average);

        projectRepository.save(project);

        return dto;
    }

    private ProjectDTO toDTO(Project project) {

        return new ProjectDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getProfile().getId()
        );
    }
}