package com.codegym.service.answer;

import com.codegym.model.Answer;
import com.codegym.service.IGeneralService;

public interface IAnswerService extends IGeneralService<Answer> {
    Iterable<Answer>findAllByQuestion(Long id);
}
