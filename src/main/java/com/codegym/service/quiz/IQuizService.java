package com.codegym.service.quiz;

import com.codegym.model.Quiz;
import com.codegym.service.IGeneralService;

public interface IQuizService extends IGeneralService<Quiz> {
    public Iterable<Quiz> findByName(String name);
}
