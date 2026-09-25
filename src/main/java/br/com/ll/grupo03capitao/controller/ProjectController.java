package br.com.ll.grupo03capitao.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import br.com.ll.grupo03capitao.dto.ProjectDTO;
import br.com.ll.grupo03capitao.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> create(
            @Valid @RequestBody ProjectDTO projectDTO) {

        return ResponseEntity.ok(
                projectService.create(projectDTO)
        );
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> findAll() {

        return ResponseEntity.ok(
                projectService.findAll()
        );
    }
}