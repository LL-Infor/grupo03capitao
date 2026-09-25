package br.com.ll.grupo03capitao.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ProfileDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Email(message = "Informe um e-mail válido")
    private String email;

    private String github;

    public ProfileDTO() {
    }

    public ProfileDTO(Long id, String name, String email, String github) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.github = github;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}