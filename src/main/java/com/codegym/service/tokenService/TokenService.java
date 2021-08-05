package com.codegym.service.tokenService;

import com.codegym.repository.TokenRepository;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    public Token findTokenByName(String token) {
        return tokenRepository.findTokenByName(token);
    }

    public boolean checkValidToken(String token) {
        if (findTokenByName(token) == null) return false;
        return true;
    }

    public void delete(String token) {
        tokenRepository.delete(findTokenByName(token));
    }

    public Token save(Token token) {
        return tokenRepository.save(token);
    }

    public String getJwtFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }

        return null;
    }
}