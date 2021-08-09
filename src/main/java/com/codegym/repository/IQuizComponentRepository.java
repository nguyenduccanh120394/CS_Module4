package com.codegym.repository;

import com.codegym.model.QuizComponent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizComponentRepository extends PagingAndSortingRepository<QuizComponent,Long> {
}
