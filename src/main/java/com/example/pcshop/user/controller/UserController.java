package com.example.pcshop.user.controller;

import com.example.pcshop.pc_components.exceptions.AlreadyExists;
import com.example.pcshop.user.entities.Role;
import com.example.pcshop.user.entities.User;
import com.example.pcshop.user.model.UserModel;
import com.example.pcshop.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Operation(summary = "Create new user", description = "Creates new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request - The request was invalid"),
    })
    @PostMapping
    @ResponseBody()
    public ResponseEntity<?> createUser(@RequestBody User user){
        try {
            return ResponseEntity.ok(userService.saveUser(user)
                    .orElseThrow());
        }catch (AlreadyExists e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @Operation(summary = "Get all users", description = "Creates new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request - The request was invalid"),
    })
    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @Operation(summary = "Get all users by role", description = "Get all users by role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Bad Request - The request was invalid"),
    })
    @GetMapping("/by-role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable Role role) {
        List<User> users = userService.getUsersByRole(role);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/user-model")
    public List<UserModel> getAllUsersModel(){
        return userService.findAllUserModel();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<User>> getAllUserByEmail(@PathVariable String email){
        List<User> users = userService.findAllByEmail(email);
        if(!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user){
        return userService.updateUser(id, user)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long userId){
        userService.deleteById(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }



}
