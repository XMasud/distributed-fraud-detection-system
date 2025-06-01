package com.pm.userservice.controller;

import com.pm.userservice.dto.UserResponseDTO;
import com.pm.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{country}")
    public List<UserResponseDTO> getUsersByCountry(@PathVariable String country) {
        List<UserResponseDTO> users = userService.getUserByCountry(country);

        return users;
    }
}
