package br.com.ll.grupo03capitao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ll.grupo03capitao.dto.ProjectDTO;
import br.com.ll.grupo03capitao.model.Profile;
import br.com.ll.grupo03capitao.model.Project;
import br.com.ll.grupo03capitao.repository.ProfileRepository;
import br.com.ll.grupo03capitao.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProfileRepository profileRepository;

    public ProjectService(
            ProjectRepository projectRepository,
            ProfileRepository profileRepository) {

        this.projectRepository = projectRepository;
        this.profileRepository = profileRepository;
    }

    public ProjectDTO create(ProjectDTO dto) {

        Profile profile = profileRepository.findById(dto.getProfileId())
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        Project project = new Project();

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setProfile(profile);

        Project saved = projectRepository.save(project);

        return new ProjectDTO(
                saved.getId(),
                saved.getName(),
                saved.getDescription(),
                saved.getProfile().getId()
        );
    }

    public List<ProjectDTO> findAll() {

        return projectRepository.findAll()
                .stream()
                .map(project -> new ProjectDTO(
                        project.getId(),
                        project.getName(),
                        project.getDescription(),
                        project.getProfile().getId()
                ))
                .toList();
    }
}