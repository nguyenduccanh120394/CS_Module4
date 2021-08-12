package com.codegym.service.quizComponent;

import com.codegym.model.Quiz;
import com.codegym.model.QuizComponent;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface IQuizComponentService extends IGeneralService<QuizComponent> {
    Iterable<QuizComponent> findByQuiz(Optional<Quiz> quiz);

}
