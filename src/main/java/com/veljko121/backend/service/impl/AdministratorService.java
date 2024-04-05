package com.veljko121.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.exception.EmailNotUniqueException;
import com.veljko121.backend.core.exception.UsernameNotUniqueException;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Administrator;
import com.veljko121.backend.repository.AdministartorRepository;
import com.veljko121.backend.service.IAdministratorService;
import com.veljko121.backend.service.IUserService;

@Service
public class AdministratorService extends CRUDService<Administrator, Integer> implements IAdministratorService{
    private final IUserService userService;

    private final AdministartorRepository administratorRepository;

    @Autowired
    public AdministratorService(AdministartorRepository repository, AdministartorRepository administratorRepository, IUserService userService) {
        super(repository);
        this.administratorRepository = administratorRepository;
        this.userService = userService;
    }

    @Override
    public Administrator save(Administrator administrator) {
        if (existsByUsername(administrator.getUsername())) throw new UsernameNotUniqueException(administrator.getUsername());
        if (existsByEmail(administrator.getEmail())) throw new EmailNotUniqueException(administrator.getEmail());

        return administratorRepository.save(administrator);
    }

    private Boolean existsByUsername(String username) {
        return userService.existsByUsername(username);
    }
    
    private Boolean existsByEmail(String email) {
        return userService.existsByEmail(email);
    }
}
