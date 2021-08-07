package com.codegym.repository;

import com.codegym.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRepository extends PagingAndSortingRepository<Answer, Long> {
    @Query("select a from Answer a where a.question.id = ?1")
    public Iterable<Answer>findAllByQuestion(Long id);
}
