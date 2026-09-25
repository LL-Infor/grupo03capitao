package br.com.ll.grupo03capitao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ll.grupo03capitao.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}