package com.veljko121.backend.service.impl;

import com.veljko121.backend.service.IOrganizerService;
import com.veljko121.backend.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.exception.EmailNotUniqueException;
import com.veljko121.backend.core.exception.UsernameNotUniqueException;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Organizer;
import com.veljko121.backend.repository.OrganizerRepository;

@Service
public class OrganizerService extends CRUDService<Organizer, Integer> implements IOrganizerService{
    
    private final IUserService userService;

    private final OrganizerRepository organizerRepository;

    @Autowired
    public OrganizerService(OrganizerRepository repository, OrganizerRepository organizerRepository, IUserService userService) {
        super(repository);
        this.organizerRepository = organizerRepository;
        this.userService = userService;
    }

    @Override
    public Organizer save(Organizer organizer) {
        if (existsByUsername(organizer.getUsername())) throw new UsernameNotUniqueException(organizer.getUsername());
        if (existsByEmail(organizer.getEmail())) throw new EmailNotUniqueException(organizer.getEmail());

        return organizerRepository.save(organizer);
    }

    private Boolean existsByUsername(String username) {
        return userService.existsByUsername(username);
    }
    
    private Boolean existsByEmail(String email) {
        return userService.existsByEmail(email);
    }
}
