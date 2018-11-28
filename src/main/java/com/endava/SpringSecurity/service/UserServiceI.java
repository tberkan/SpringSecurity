package com.endava.SpringSecurity.service;

import com.endava.SpringSecurity.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceI extends UserDetailsService {
    User findByUsername(String username);

    void save(User user);

}
