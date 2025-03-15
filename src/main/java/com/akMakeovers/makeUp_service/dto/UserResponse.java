package com.akMakeovers.makeUp_service.dto;

import com.akMakeovers.makeUp_service.entity.Role;
import lombok.Data;

@Data
public class UserResponse {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private Role role;
}
