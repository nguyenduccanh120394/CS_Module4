package com.codegym.repository;

import jdk.nashorn.internal.parser.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Long> {
    Token findTokenByName(String token);
}
