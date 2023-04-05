package com.choisi.entity;


import com.choisi.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_user")
public class UserEntity extends UserDto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(55)")
    private String name;

    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "role", columnDefinition = "VARCHAR(10)")
    private String role;

    @Column(name = "is_account_non_locked", columnDefinition = "BOOLEAN")
    private boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired", columnDefinition = "BOOLEAN")
    private boolean isCredentialsNonExpired;

    @Column(name = "is_enabled", columnDefinition = "BOOLEAN")
    private boolean isEnabled;
}
