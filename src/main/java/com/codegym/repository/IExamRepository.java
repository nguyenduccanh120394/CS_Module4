package com.codegym.repository;

import com.codegym.model.Exam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExamRepository extends PagingAndSortingRepository<Exam, Long> {
    @Query("select e from Exam e where e.user.id = ?1")
    Iterable<Exam> findByIdUser(Long id);
}
