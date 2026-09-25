package br.com.ll.grupo03capitao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import br.com.ll.grupo03capitao.dto.ProfileDTO;
import br.com.ll.grupo03capitao.service.ProfileService;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> create(
            @Valid @RequestBody ProfileDTO profileDTO) {

        return ResponseEntity.ok(
                profileService.create(profileDTO)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> findById(
            @PathVariable Long id) {

        ProfileDTO profile = profileService.findById(id);

        if (profile == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(profile);
    }
}