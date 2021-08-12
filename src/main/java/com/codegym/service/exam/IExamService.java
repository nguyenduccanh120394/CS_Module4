package com.codegym.service.exam;

import com.codegym.model.Exam;
import com.codegym.service.IGeneralService;

public interface IExamService extends IGeneralService<Exam> {
    Iterable<Exam> findByIdUser(Long id);
}
