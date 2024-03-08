package com.blackmanx.falerotraining.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blackmanx.falerotraining.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
