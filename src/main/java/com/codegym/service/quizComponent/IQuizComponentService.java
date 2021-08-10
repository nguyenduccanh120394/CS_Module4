package com.codegym.service.quizComponent;

import com.codegym.model.QuizComponent;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuizComponentService extends IGeneralService<QuizComponent> {
    Page<QuizComponent> searchByIdQuiz(Long id, Pageable pageable);
}
