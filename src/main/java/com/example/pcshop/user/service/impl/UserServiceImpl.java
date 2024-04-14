package com.example.pcshop.user.service.impl;

import com.example.pcshop.pc_components.exceptions.AlreadyExists;
import com.example.pcshop.user.entities.Role;
import com.example.pcshop.user.entities.User;
import com.example.pcshop.user.model.UserModel;
import com.example.pcshop.user.repository.UserRepository;
import com.example.pcshop.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public Optional<User> saveUser(User user) {
        Optional<User> savedUser = userRepository.findByEmail(user.getEmail());
        Optional<User> savedUser1 = userRepository.findById(user.getId());
        if (savedUser.isPresent())
            throw new AlreadyExists("User already exists with given email: " +user.getEmail());
        else if (savedUser1.isPresent()) {
            throw new AlreadyExists("User already exists with given id: " +user.getId());
        }
        return Optional.of(userRepository.save(user));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public List<UserModel> findAllUserModel() {
        return userRepository.findAll()
                .stream()
                .map(User::map).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllByEmail(String email) {
        return userRepository.findAll().stream()
                .filter(user -> user.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> updateUser(long id, User updatedUser) {
        return findById(id)
                .map(savedUser ->{
                    savedUser.setEmail(updatedUser.getEmail());
                    savedUser.setPassword(updatedUser.getPassword());
                    savedUser.setFirstName(updatedUser.getFirstName());
                    savedUser.setLastName(updatedUser.getLastName());
                    savedUser.setCity(updatedUser.getCity());
                    savedUser.setAddress(updatedUser.getAddress());
                    return userRepository.save(savedUser);
                });
    }

    @Override
    public void deleteById(long userId) {
        userRepository.deleteById(userId);

    }
}
