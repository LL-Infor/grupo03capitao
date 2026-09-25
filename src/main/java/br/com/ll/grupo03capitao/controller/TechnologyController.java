package br.com.ll.grupo03capitao.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import br.com.ll.grupo03capitao.model.Technology;
import br.com.ll.grupo03capitao.repository.TechnologyRepository;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyRepository technologyRepository;

    public TechnologyController(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @PostMapping
    public ResponseEntity<Technology> create(
            @Valid @RequestBody Technology technology) {

        Technology savedTechnology = technologyRepository.save(technology);

        return ResponseEntity.ok(savedTechnology);
    }

    @GetMapping
    public ResponseEntity<List<Technology>> findAll() {

        return ResponseEntity.ok(technologyRepository.findAll());
    }
}