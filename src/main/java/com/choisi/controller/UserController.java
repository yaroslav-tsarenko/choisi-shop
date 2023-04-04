package com.choisi.controller;


import com.choisi.entity.UserEntity;
import com.choisi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;


    @GetMapping
    public List<UserEntity> loadAll(){
        return userService.loadAll();
    }

    @GetMapping("/{id}")
    public UserEntity loadById(@PathVariable("id") Long id){
        return userService.loadOne(id);
    }

    @PostMapping
    public UserEntity save(@RequestBody UserEntity user){
        return userService.save(user);
    }

    @PutMapping
    public UserEntity update(@RequestBody UserEntity user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
}
