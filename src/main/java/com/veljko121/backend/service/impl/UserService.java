package com.veljko121.backend.service.impl;

import java.util.NoSuchElementException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.veljko121.backend.model.User;
import com.veljko121.backend.repository.UserRepository;
import com.veljko121.backend.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public User findByUsername(String username) throws NoSuchElementException {
        return userRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    
    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    
}
