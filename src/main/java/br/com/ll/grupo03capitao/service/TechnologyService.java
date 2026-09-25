package br.com.ll.grupo03capitao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ll.grupo03capitao.dto.TechnologyDTO;
import br.com.ll.grupo03capitao.model.Technology;
import br.com.ll.grupo03capitao.repository.TechnologyRepository;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public TechnologyDTO create(TechnologyDTO dto) {

        Technology technology = new Technology();

        technology.setName(dto.getName());

        Technology saved = technologyRepository.save(technology);

        return new TechnologyDTO(
                saved.getId(),
                saved.getName()
        );
    }

    public List<TechnologyDTO> findAll() {

        return technologyRepository.findAll()
                .stream()
                .map(technology -> new TechnologyDTO(
                        technology.getId(),
                        technology.getName()
                ))
                .toList();
    }
}