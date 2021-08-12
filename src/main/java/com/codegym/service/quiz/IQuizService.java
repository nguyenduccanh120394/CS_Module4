package com.codegym.service.quiz;

import com.codegym.model.Quiz;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuizService extends IGeneralService<Quiz> {
    Iterable<Quiz> findByName(String name);

    Iterable<Quiz> findByNameContaining(String name);

    Page<Quiz> findAll(Pageable pageable);
}
