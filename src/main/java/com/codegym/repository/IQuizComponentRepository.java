package com.codegym.repository;

import com.codegym.model.Quiz;
import com.codegym.model.QuizComponent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IQuizComponentRepository extends PagingAndSortingRepository<QuizComponent,Long> {
    Iterable<QuizComponent> findByQuiz(Optional<Quiz> quiz);
}
