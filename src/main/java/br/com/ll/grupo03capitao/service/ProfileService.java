package br.com.ll.grupo03capitao.service;

import org.springframework.stereotype.Service;

import br.com.ll.grupo03capitao.dto.ProfileDTO;
import br.com.ll.grupo03capitao.model.Profile;
import br.com.ll.grupo03capitao.repository.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileDTO create(ProfileDTO dto) {

        Profile profile = new Profile();

        profile.setName(dto.getName());
        profile.setEmail(dto.getEmail());
        profile.setGithub(dto.getGithub());

        Profile saved = profileRepository.save(profile);

        return new ProfileDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getGithub()
        );
    }

    public ProfileDTO findById(Long id) {

        return profileRepository.findById(id)
                .map(profile -> new ProfileDTO(
                        profile.getId(),
                        profile.getName(),
                        profile.getEmail(),
                        profile.getGithub()
                ))
                .orElse(null);
    }
}