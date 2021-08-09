package com.codegym.service.quizComponent;

import com.codegym.model.QuizComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizComponentService implements IQuizComponentService{

    @Autowired
    IQuizComponentService quizComponentService;

    @Override
    public Iterable<QuizComponent> findAll() {
        return quizComponentService.findAll();
    }

    @Override
    public Optional<QuizComponent> findById(Long id) {
        return quizComponentService.findById(id);
    }

    @Override
    public QuizComponent save(QuizComponent quizComponent) {
        return quizComponentService.save(quizComponent);
    }

    @Override
    public void remove(Long id) {
quizComponentService.remove(id);
    }
}
