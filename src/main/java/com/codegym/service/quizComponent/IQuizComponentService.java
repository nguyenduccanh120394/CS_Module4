package com.codegym.service.quizComponent;

import com.codegym.model.Quiz;
import com.codegym.model.QuizComponent;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface IQuizComponentService extends IGeneralService<QuizComponent> {
    Iterable<QuizComponent> findByQuiz(Optional<Quiz> quiz);
    Page<QuizComponent> searchByIdQuiz(Long id, Pageable pageable);
    Iterable<QuizComponent> getAllQuesById(Long id);

}
