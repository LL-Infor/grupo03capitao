package br.com.ll.grupo03capitao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import br.com.ll.grupo03capitao.model.Profile;
import br.com.ll.grupo03capitao.repository.ProfileRepository;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {

        this.profileRepository = profileRepository;
    }

    @PostMapping
    public ResponseEntity<Profile> create(
            @Valid @RequestBody Profile profile) {

        Profile savedProfile = profileRepository.save(profile);

        return ResponseEntity.ok(savedProfile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> findById(@PathVariable Long id) {

        return profileRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}