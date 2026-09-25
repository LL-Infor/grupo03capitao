package br.com.ll.grupo03capitao.dto;

import jakarta.validation.constraints.NotBlank;

public class TechnologyDTO {

    private Long id;

    @NotBlank(message = "O nome da tecnologia é obrigatório")
    private String name;

    public TechnologyDTO() {
    }

    public TechnologyDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
}