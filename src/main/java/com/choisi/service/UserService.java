package com.choisi.service;

import com.choisi.entity.UserEntity;
import com.choisi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> loadAll(){
        return userRepository.findAll();
    }

    public UserEntity loadOne(Long id){
        return userRepository.findUserById(id);
    }

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        UserEntity userEntity = loadOne(id);
        userRepository.delete(userEntity);
    }

    public UserEntity update(UserEntity newUser){
        UserEntity oldUser = loadOne(newUser.getId());
        boolean exists = Objects.nonNull(oldUser);
        if (exists){
            BeanUtils.copyProperties(newUser, oldUser);
            return save(oldUser);
        }else {
            return save(newUser);
        }
    }
}
