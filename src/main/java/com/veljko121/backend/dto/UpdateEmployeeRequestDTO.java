package com.veljko121.backend.dto;

import com.veljko121.backend.core.enums.Role;
import lombok.Data;

@Data
public class UpdateEmployeeRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Role role;
}
