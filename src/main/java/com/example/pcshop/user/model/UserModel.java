package com.example.pcshop.user.model;

import com.example.pcshop.user.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UserModel {

    private String email;

    private String password;

    private String firstName;

    private Role role;
}

