package com.pm.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequestDTO {

    private String name;
    private String email;
    private String address;
    private LocalDate dateOfBirth;
    private String gender;
    private String country;

    public UserRequestDTO(String name, String email, String address, LocalDate dateOfBirth, String gender, String country){
        this.name = name;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.country = country;
    }
}
