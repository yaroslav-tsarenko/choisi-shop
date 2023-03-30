package com.choisi.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto {
    private Long id;
    private String FirstName;
    private String LastName;
    private String email;
    private String phoneNumber;
    private UserDto user;
}
