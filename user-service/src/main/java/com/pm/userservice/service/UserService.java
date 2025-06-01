package com.pm.userservice.service;

import com.pm.userservice.dto.UserResponseDTO;
import com.pm.userservice.exception.UserNotFoundException;
import com.pm.userservice.model.User;
import com.pm.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getCountry(),
                        user.getTotalBalance()
                )).collect(Collectors.toList());
    }

    public List<UserResponseDTO> getUserByCountry(String country) {

        List<User> users = userRepository.findByCountry(country);

        if(users.isEmpty())
            throw new UserNotFoundException("No user found in country: "+country);

        return users.stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getCountry(),
                        user.getTotalBalance()
                )).collect(Collectors.toList());
    }

}
