package com.choisi.service;

import com.choisi.entity.UserEntity;
import com.choisi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> loadAll() {
        return null;
    }
}
