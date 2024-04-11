package com.veljko121.backend.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veljko121.backend.core.dto.ErrorResponseDTO;
import com.veljko121.backend.core.dto.ExistsResponseDTO;
import com.veljko121.backend.core.enums.Role;
import com.veljko121.backend.core.exception.EmailNotUniqueException;
import com.veljko121.backend.core.exception.UsernameNotUniqueException;
import com.veljko121.backend.core.service.IJwtService;
import com.veljko121.backend.dto.AuthenticationResponseDTO;
import com.veljko121.backend.dto.CredentialsDTO;
import com.veljko121.backend.dto.RegisterRequestDTO;
import com.veljko121.backend.dto.UpdateProfileRequestDTO;
import com.veljko121.backend.model.Curator;
import com.veljko121.backend.model.Guest;
import com.veljko121.backend.model.Organizer;
import com.veljko121.backend.model.Restaurateur;
import com.veljko121.backend.service.IAuthenticationService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final IAuthenticationService authenticationService;
    private final IJwtService jwtService;

    private final ModelMapper modelMapper;
    private final Logger logger;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDTO requestDTO) {
        try {
            var user = modelMapper.map(requestDTO, Guest.class);
            authenticationService.register(user);
    
            var jwt = jwtService.generateJwt(user);
            var authenticationResponse = new AuthenticationResponseDTO(jwt);
    
            return ResponseEntity.status(HttpStatus.CREATED).body(authenticationResponse);

        } catch (UsernameNotUniqueException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(e.getMessage()));
            
        } catch (EmailNotUniqueException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> logIn(@Valid @RequestBody CredentialsDTO credentialsDTO) {
        var user = authenticationService.login(credentialsDTO);
        var jwt = jwtService.generateJwt(user);
        var authenticationResponse = new AuthenticationResponseDTO(jwt);

        return ResponseEntity.ok().body(authenticationResponse);
    }

    @GetMapping("{username}/username-exists")
    public ResponseEntity<ExistsResponseDTO> usernameExists(@PathVariable String username) {
        return ResponseEntity.ok().body(new ExistsResponseDTO(authenticationService.usernameExists(username)));
    }

    @GetMapping("{email}/email-exists")
    public ResponseEntity<ExistsResponseDTO> emailExists(@PathVariable @Email String email) {
        return ResponseEntity.ok().body(new ExistsResponseDTO(authenticationService.emailExists(email)));
    }

    @PostMapping("/registerEmployee")
    public ResponseEntity<?> registerEmployee(@Valid @RequestBody RegisterRequestDTO requestDTO) {
        try {

            var jwt = "";
            if(requestDTO.getRole() == Role.CURATOR){
                var user = modelMapper.map(requestDTO, Curator.class);
                authenticationService.registerCurator(user);
                jwt = jwtService.generateJwt(user);
            }else if(requestDTO.getRole() == Role.ORGANIZER){
                var user = modelMapper.map(requestDTO, Organizer.class);
                authenticationService.registerOrganizer(user);
                jwt = jwtService.generateJwt(user);
            }else if(requestDTO.getRole() == Role.RESTAURATEUR){
                var user = modelMapper.map(requestDTO, Restaurateur.class);
                authenticationService.registerRestaurateur(user);
                jwt = jwtService.generateJwt(user);
            }

            var authenticationResponse = new AuthenticationResponseDTO(jwt);
    
            return ResponseEntity.status(HttpStatus.CREATED).body(authenticationResponse);

        } catch (UsernameNotUniqueException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(e.getMessage()));
            
        } catch (EmailNotUniqueException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProfile(@RequestBody UpdateProfileRequestDTO requestDTO) {
        try {
            // TODO: get logged in user
            var loggedInUserUsername = jwtService.getLoggedInUserUsername();
            logger.info(loggedInUserUsername);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

}
