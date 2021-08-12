package com.codegym.repository;
import com.codegym.model.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizRepository extends PagingAndSortingRepository<Quiz,Long> {
    @Query("select q from Quiz q where q.name like ?1")
    Iterable<Quiz> findByName(String name);
    Iterable<Quiz>findByNameContaining(String name);
    @Override
    Page<Quiz> findAll(Pageable pageable);
}
