package br.com.ll.grupo03capitao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ll.grupo03capitao.model.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

}