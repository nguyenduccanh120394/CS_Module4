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
        return answerRepository.findById(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void remove(Long id) {
        answerRepository.deleteById(id);

    }

    @Override
    public Iterable<Answer> findAllByQuestion(Long id) {
        return answerRepository.findAllByQuestion(id);
    }
}
