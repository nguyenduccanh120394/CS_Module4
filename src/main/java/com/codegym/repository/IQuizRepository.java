package com.codegym.repository;

import com.codegym.model.Quiz;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizRepository extends PagingAndSortingRepository<Quiz,Long> {
}
