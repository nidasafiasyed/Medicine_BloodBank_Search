package com.nida.security.service;

import java.util.List;

import com.nida.security.model.User;
import com.nida.security.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}