package com.blackmanx.falerotraining.services;

import java.util.List;

import com.blackmanx.falerotraining.dto.UserDto;
import com.blackmanx.falerotraining.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
