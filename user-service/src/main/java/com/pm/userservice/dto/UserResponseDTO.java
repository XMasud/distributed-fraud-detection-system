package com.pm.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String country;
    private Double totalBalance;

    public UserResponseDTO(UUID id, String name, String email, String country, Double totalBalance){
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.totalBalance = totalBalance;
    }
}
