package com.codegym.service.quizComponent;

import com.codegym.model.QuizComponent;
import com.codegym.repository.IQuizComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizComponentService implements IQuizComponentService {

    @Autowired
    IQuizComponentRepository quizComponentRepository;

    @Override
    public Iterable<QuizComponent> findAll() {
        return quizComponentRepository.findAll();
    }

    @Override
    public Optional<QuizComponent> findById(Long id) {
        return quizComponentRepository.findById(id);
    }

    @Override
    public QuizComponent save(QuizComponent quizComponent) {
        return quizComponentRepository.save(quizComponent);
    }

    @Override
    public void remove(Long id) {
        quizComponentRepository.deleteById(id);
    }
}