package com.codegym.service.exam;

import com.codegym.model.Exam;
import com.codegym.repository.IExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamService implements IExamService{
    @Autowired
    IExamRepository examRepository;
    @Override
    public Iterable<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public Optional<Exam> findById(Long id) {
        return examRepository.findById(id);
    }

    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public void remove(Long id) {
        examRepository.deleteById(id);

    }

    @Override
    public Iterable<Exam> findByIdUser(Long id) {
        return examRepository.findByIdUser(id);
    }
}
