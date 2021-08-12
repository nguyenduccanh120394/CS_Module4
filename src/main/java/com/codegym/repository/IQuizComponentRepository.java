package com.codegym.repository;

import com.codegym.model.Quiz;
import com.codegym.model.QuizComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IQuizComponentRepository extends PagingAndSortingRepository<QuizComponent,Long> {
    @Query("select q from QuizComponent q where q.quiz.id = ?1")
    Page<QuizComponent> searchByIdQuiz(Long id, Pageable pageable);
    Iterable<QuizComponent> findByQuiz(Optional<Quiz> quiz);

    @Query("select q from QuizComponent q where q.quiz.id = ?1")
    Iterable<QuizComponent> getAllQuesByIdQuiz(Long id);


}
