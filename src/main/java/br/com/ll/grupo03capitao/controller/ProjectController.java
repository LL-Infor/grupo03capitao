package br.com.ll.grupo03capitao.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import br.com.ll.grupo03capitao.model.Project;
import br.com.ll.grupo03capitao.repository.ProjectRepository;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping
    public ResponseEntity<Project> create(
            @Valid @RequestBody Project project) {

        Project savedProject = projectRepository.save(project);

        return ResponseEntity.ok(savedProject);
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAll() {

        return ResponseEntity.ok(projectRepository.findAll());
    }
}