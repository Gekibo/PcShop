package com.example.pcshop.user.repository;

import com.example.pcshop.user.entities.Role;
import com.example.pcshop.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findByEmail(String email);
    List<User> findAllByRole(Role role);
    List<User>findAllByEmail(String email);
    Optional<User>findAllByFirstName(String firstName);
    Optional<User>findAllByLastName(String lastName);
    Optional<User>findAllByCity(String city);
}
