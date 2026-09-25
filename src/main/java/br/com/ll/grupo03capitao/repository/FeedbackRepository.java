package br.com.ll.grupo03capitao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ll.grupo03capitao.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}