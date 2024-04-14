package com.example.pcshop.user.entities;

import com.example.pcshop.user.model.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;


    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    public UserModel map(){
        return new UserModel(this.getEmail(),this.getPassword(),this.getFirstName(),this.role);
    }
}
