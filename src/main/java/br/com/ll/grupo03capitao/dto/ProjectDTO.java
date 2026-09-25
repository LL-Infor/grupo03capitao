package br.com.ll.grupo03capitao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProjectDTO {

    private Long id;

    @NotBlank(message = "O nome do projeto é obrigatório")
    private String name;

    @NotBlank(message = "A descrição do projeto é obrigatória")
    private String description;

    @NotNull(message = "O ID do perfil é obrigatório")
    private Long profileId;

    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String name, String description, Long profileId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.profileId = profileId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}