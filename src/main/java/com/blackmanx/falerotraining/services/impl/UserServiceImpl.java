package com.blackmanx.falerotraining.services.impl;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blackmanx.falerotraining.dto.UserDto;
import com.blackmanx.falerotraining.entity.Role;
import com.blackmanx.falerotraining.entity.User;
import com.blackmanx.falerotraining.repo.RoleRepo;
import com.blackmanx.falerotraining.repo.UserRepo;
import com.blackmanx.falerotraining.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepository;
    private RoleRepo roleRepository;


    public UserServiceImpl(UserRepo userRepository,
                           RoleRepo roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        user.setGender(userDto.getGender());
        user.setIdCard(userDto.getIdCard());
        user.setDateOfBirth(userDto.getDateOfBirth());
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setGender(user.getGender());
        userDto.setIdCard(user.getIdCard());
        userDto.setDateOfBirth(user.getDateOfBirth());
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
