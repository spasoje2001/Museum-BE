package com.veljko121.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.exception.EmailNotUniqueException;
import com.veljko121.backend.core.exception.UsernameNotUniqueException;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Guest;
import com.veljko121.backend.repository.GuestRepository;
import com.veljko121.backend.service.IGuestService;
import com.veljko121.backend.service.IUserService;

@Service
public class GuestService extends CRUDService<Guest, Integer> implements IGuestService {

    private final IUserService userService;

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository repository, GuestRepository guestRepository, IUserService userService) {
        super(repository);
        this.guestRepository = guestRepository;
        this.userService = userService;
    }

    @Override
    public Guest save(Guest guest) {
        if (existsByUsername(guest.getUsername())) throw new UsernameNotUniqueException(guest.getUsername());
        if (existsByEmail(guest.getEmail())) throw new EmailNotUniqueException(guest.getEmail());

        return guestRepository.save(guest);
    }

    private Boolean existsByUsername(String username) {
        return userService.existsByUsername(username);
    }
    
    private Boolean existsByEmail(String email) {
        return userService.existsByEmail(email);
    }
    
}
