package com.pm.userservice.controller;

import com.pm.userservice.dto.UserRequestDTO;
import com.pm.userservice.dto.UserResponseDTO;
import com.pm.userservice.service.UserService;
import jakarta.validation.Valid;
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

    @GetMapping
    public List<UserResponseDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{country}")
    public List<UserResponseDTO> getUsersByCountry(@PathVariable String country) {
        return userService.getUserByCountry(country);
    }

    @PostMapping
    public UserResponseDTO saveUser(@RequestBody @Valid UserRequestDTO request) {
        UserResponseDTO response = userService.createUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED).getBody();
    }
}
