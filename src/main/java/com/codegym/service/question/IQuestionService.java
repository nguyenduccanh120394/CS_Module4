package com.codegym.service.question;

import com.codegym.model.Question;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService extends IGeneralService<Question> {
    Iterable<Question> findByCategory(String category);
    Page<Question> findAll(Pageable pageable);
    Iterable<Question>findAllByQuestionCategoryId(Long questionCategoryId);
}
