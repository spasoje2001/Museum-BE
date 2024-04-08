package com.veljko121.backend.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.veljko121.backend.dto.CredentialsDTO;
import com.veljko121.backend.model.Curator;
import com.veljko121.backend.model.Guest;
import com.veljko121.backend.model.Organizer;
import com.veljko121.backend.model.Restaurateur;
import com.veljko121.backend.model.User;
import com.veljko121.backend.service.IAuthenticationService;
import com.veljko121.backend.service.ICuratorService;
import com.veljko121.backend.service.IGuestService;
import com.veljko121.backend.service.IOrganizerService;
import com.veljko121.backend.service.IRestaurateurService;
import com.veljko121.backend.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {

    private final IUserService userService;

    private final IGuestService guestService;

    private final ICuratorService curatorService;

    private final IRestaurateurService restaurateurService;

    private final IOrganizerService organizerService;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(Guest guest) {
        //guest.setRole(Role.GUEST);
        guest.setPassword(passwordEncoder.encode(guest.getPassword()));
        return guestService.save(guest);
    }

    @Override
    public User registerCurator(Curator curator) {
        //curator.setRole(Role.CURATOR);
        curator.setPassword(passwordEncoder.encode(curator.getPassword()));
        return curatorService.save(curator);
    }

    @Override
    public User registerOrganizer(Organizer organizer) {
        //organizer.setRole(Role.ORGANIZER);
        organizer.setPassword(passwordEncoder.encode(organizer.getPassword()));
        return organizerService.save(organizer);
    }

    @Override
    public User registerRestaurateur(Restaurateur restaurateur) {
        //restaurateur.setRole(Role.RESTAURATEUR);
        restaurateur.setPassword(passwordEncoder.encode(restaurateur.getPassword()));
        return restaurateurService.save(restaurateur);
    }

    
    @Override
    public User login(CredentialsDTO credentialsDTO) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(credentialsDTO.getUsername(), credentialsDTO.getPassword())
        );
        return userService.findByUsername(credentialsDTO.getUsername());
    }

    @Override
    public Boolean usernameExists(String username) {
        return userService.existsByUsername(username);
    }

    @Override
    public Boolean emailExists(String email) {
        return userService.existsByEmail(email);
    }
    
}
