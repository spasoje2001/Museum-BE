package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.enums.ExhibitionTheme;
import com.veljko121.backend.model.Exhibition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veljko121.backend.core.exception.EmailNotUniqueException;
import com.veljko121.backend.core.exception.UsernameNotUniqueException;
import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.model.Guest;
import com.veljko121.backend.repository.GuestRepository;
import com.veljko121.backend.service.IGuestService;
import com.veljko121.backend.service.IUserService;

import java.util.List;

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
        if (userService.existsByUsername(guest.getUsername())) throw new UsernameNotUniqueException(guest.getUsername());
        if (userService.existsByEmail(guest.getEmail())) throw new EmailNotUniqueException(guest.getEmail());

        return guestRepository.save(guest);
    }

    @Override
    public Guest update(Guest updated) {
        if (!userService.canUsernameBeChanged(updated)) throw new UsernameNotUniqueException(updated.getUsername());
        if (!userService.canEmailBeChanged(updated)) throw new EmailNotUniqueException(updated.getEmail());

        var oldGuest = findById(updated.getId());
        updated.setPassword(oldGuest.getPassword());
        updated.setRole(oldGuest.getRole());

        return guestRepository.save(updated);
    }

    @Override
    public Guest findByUsername(String username) {
        return guestRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public List<Guest> findUsersWithTicketsForExhibition(Exhibition exhibition) {
        return guestRepository.findUsersWithTicketsForExhibition(exhibition.getId());
    }

    @Override
    public List<Guest> findUsersInterestedInTheme(ExhibitionTheme theme) {
        return guestRepository.findUsersInterestedInTheme(theme);
    }

    @Override
    public List<Guest> findUsersWhoReviewedExhibition(Exhibition exhibition) {
        return guestRepository.findUsersWhoReviewedExhibition(exhibition);
    }

    @Override
    public List<Guest> findUsersWithoutTicketsForExhibition(Exhibition exhibition) {
        return guestRepository.findUsersWithoutTicketsForExhibition(exhibition);
    }
    
}
