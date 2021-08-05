package com.codegym.service.question;

import com.codegym.model.Question;
import com.codegym.service.IGeneralService;

public interface IQuestionService extends IGeneralService<Question> {
    Iterable<Question> findByCategory(String category);
}
