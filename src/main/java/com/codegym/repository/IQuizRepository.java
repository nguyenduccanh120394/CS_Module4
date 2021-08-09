package com.codegym.repository;

import com.codegym.model.Quiz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizRepository extends PagingAndSortingRepository<Quiz,Long> {
    @Query("select q from Quiz q where q.name like ?1")
    public Iterable<Quiz> findByName(String name);
}
