package com.vivah.makeUp_service.dto;

import com.vivah.makeUp_service.entity.Role;
import lombok.Data;

@Data
public class UserResponse {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private Role role;
}
