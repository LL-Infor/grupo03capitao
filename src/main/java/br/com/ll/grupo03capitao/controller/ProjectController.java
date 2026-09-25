package br.com.ll.grupo03capitao.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import br.com.ll.grupo03capitao.dto.FeedbackDTO;
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
    public ResponseEntity<Page<ProjectDTO>> findAll(
            @RequestParam(required = false) String technology,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.ok(
                projectService.findAll(technology, pageable)
        );
    }

    @PutMapping("/{id}/upvote")
    public ResponseEntity<ProjectDTO> upvote(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                projectService.upvote(id)
        );
    }

    @PostMapping("/{id}/feedbacks")
    public ResponseEntity<FeedbackDTO> addFeedback(
            @PathVariable Long id,
            @Valid @RequestBody FeedbackDTO dto) {

        return ResponseEntity.ok(
                projectService.addFeedback(id, dto)
        );
    }
}