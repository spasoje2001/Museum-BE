package com.veljko121.backend.service.impl;

import java.util.NoSuchElementException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.User;
import com.veljko121.backend.repository.UserRepository;
import com.veljko121.backend.service.IUserService;

@Service
public class UserService extends CRUDService<User, Integer> implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }

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

    @Override
    public Boolean canUsernameBeChanged(User updatedUser) {
        var oldUser = findById(updatedUser.getId());

        if (existsByUsername(updatedUser.getUsername())) {
            if (oldUser.getUsername().equals(updatedUser.getUsername())) return true; // username did not change
            return false; // username changed, but exists already
        }

        return true; // username changed and doesn't exist
    }

    @Override
    public Boolean canEmailBeChanged(User updatedUser) {
        var oldUser = findById(updatedUser.getId());

        if (existsByEmail(updatedUser.getEmail())) {
            if (oldUser.getEmail().equals(updatedUser.getEmail())) return true; // email didn't change
            return false; // email changed, but exists already
        }

        return true; // email changed and doesn't exist
    }
    
}
