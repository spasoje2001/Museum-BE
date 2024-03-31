package com.veljko121.backend.service;

import com.veljko121.backend.dto.CredentialsDTO;
import com.veljko121.backend.model.Guest;
import com.veljko121.backend.model.User;

public interface IAuthenticationService {
    
    User register(Guest guest);

    User login(CredentialsDTO credentialsDTO);

    Boolean usernameExists(String username);

    Boolean emailExists(String email);

}
