package br.com.ll.grupo03capitao.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import br.com.ll.grupo03capitao.dto.TechnologyDTO;
import br.com.ll.grupo03capitao.service.TechnologyService;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping
    public ResponseEntity<TechnologyDTO> create(
            @Valid @RequestBody TechnologyDTO technologyDTO) {

        return ResponseEntity.ok(
                technologyService.create(technologyDTO)
        );
    }

    @GetMapping
    public ResponseEntity<List<TechnologyDTO>> findAll() {

        return ResponseEntity.ok(
                technologyService.findAll()
        );
    }
}