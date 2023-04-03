package com.choisi.repository;

import com.choisi.entity.UserEntity;
import org.apache.catalina.User;

public interface UserRepository {
    UserEntity findUserById(Long id);
}
