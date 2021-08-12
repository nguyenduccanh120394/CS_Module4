package com.codegym.repository;

import com.codegym.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends PagingAndSortingRepository<Question, Long> {
    @Query("select q from Question q where q.questionCategory.name like ?1")
    Iterable<Question> findByCategory(String category);
    @Override
    Page<Question> findAll(Pageable pageable);
    Iterable<Question>findAllByQuestionCategoryId(Long questionCategoryId);
}
