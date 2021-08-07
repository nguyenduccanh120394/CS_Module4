package com.codegym.repository;

import com.codegym.model.QuestionCategory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionCategoryRepository extends PagingAndSortingRepository<QuestionCategory,Long> {
}
