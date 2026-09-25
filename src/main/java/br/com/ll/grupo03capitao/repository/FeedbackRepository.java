package br.com.ll.grupo03capitao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ll.grupo03capitao.model.Feedback;
import br.com.ll.grupo03capitao.model.Project;

public interface FeedbackRepository
        extends JpaRepository<Feedback, Long> {

    List<Feedback> findByProject(Project project);
}