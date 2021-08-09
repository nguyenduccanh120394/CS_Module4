package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Iterable<User> findByUsernameContaining(String username);
    @Query(value = "from User order by address ASC ")
    Iterable<User> SortByAddress();
    @Query(value = "from User order by username ASC ")
    Iterable<User> SortByUsername();

}