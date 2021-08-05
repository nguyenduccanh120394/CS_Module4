package com.codegym.repository;

import com.codegym.model.Answer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRepository extends PagingAndSortingRepository<Answer, Long> {
}
