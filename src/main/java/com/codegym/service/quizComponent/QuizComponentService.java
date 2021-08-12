package com.codegym.service.quizComponent;

import com.codegym.model.Quiz;
import com.codegym.model.QuizComponent;
import com.codegym.repository.IQuizComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    @Override
    public Iterable<QuizComponent> findByQuiz(Optional<Quiz> quiz) {
        return quizComponentRepository.findByQuiz(quiz);

    }

    @Override
    public Page<QuizComponent> searchByIdQuiz(Long id, Pageable pageable) {
            return quizComponentRepository.searchByIdQuiz(id, pageable);
        }

    @Override
    public Iterable<QuizComponent> getAllQuesById(Long id) {
        return quizComponentRepository.getAllQuesByIdQuiz(id);
    }
}
