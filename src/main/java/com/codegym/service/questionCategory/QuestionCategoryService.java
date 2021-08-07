package com.codegym.service.questionCategory;

import com.codegym.model.QuestionCategory;
import com.codegym.repository.IQuestionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionCategoryService implements IQuestionCategoryService{

    @Autowired
    IQuestionCategoryRepository questionCategoryRepository;

    @Override
    public Iterable<QuestionCategory> findAll() {
        return questionCategoryRepository.findAll();
    }

    @Override
    public Optional<QuestionCategory> findById(Long id) {
        return questionCategoryRepository.findById(id);
    }

    @Override
    public QuestionCategory save(QuestionCategory questionCategory) {
        return questionCategoryRepository.save(questionCategory);
    }

    @Override
    public void remove(Long id) {
        questionCategoryRepository.deleteById(id);

    }
}
