package com.akMakeovers.makeUp_service.dto;

import com.akMakeovers.makeUp_service.entity.Role;
import lombok.Data;

@Data
public class UserRequest  {
    private String name;
    private String email;
    private String phone;
    private String password;
    private Role role; // ARTIST, CUSTOMER, ADMIN
}
