package com.choisi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String password;
    private String role;
    private String isExpired;
    private String isLocked;
    private String isEnabled;

}
