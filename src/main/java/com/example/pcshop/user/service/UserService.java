package com.example.pcshop.user.service;

import com.example.pcshop.user.entities.Role;
import com.example.pcshop.user.entities.User;
import com.example.pcshop.user.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsersByRole(Role role);


    Optional<User> saveUser(User user);

    List<User> findAll();

    Optional<User> findById(long id);

    List<User>findAllByEmail(String email);


    Optional<User> updateUser(long id, User updatedUser);

    void deleteById(long userId);

    List<UserModel> findAllUserModel();
}
