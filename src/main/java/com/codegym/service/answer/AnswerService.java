package com.codegym.service.answer;

import com.codegym.model.Answer;
import com.codegym.repository.IAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService implements IAnswerService {

    @Autowired
    IAnswerRepository answerRepository;

    @Override
    public Iterable<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Answer save(Answer answer) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
