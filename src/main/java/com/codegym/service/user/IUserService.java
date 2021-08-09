package com.codegym.service.user;

import com.codegym.model.User;
import com.codegym.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
    Iterable<User> findByUsernameContaining(String username);
    Iterable<User> sortByAddress();
    Iterable<User> sortByUsername();

}