package com.codegym.service.quiz;

import com.codegym.model.Quiz;
import com.codegym.repository.IQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class QuizService implements IQuizService{

    @Autowired
    IQuizRepository quizRepository;

    @Override
    public Iterable<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> findById(Long id) {
        return quizRepository.findById(id);
    }

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void remove(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Iterable<Quiz> findByName(String name) {
        return quizRepository.findByName(name);
    }

    @Override
    public Iterable<Quiz> findByNameContaining(String name) {
        return quizRepository.findByNameContaining(name);
    }

    @Override
    public Page<Quiz> findAll(Pageable pageable) {
        return quizRepository.findAll(pageable);
    }

}
