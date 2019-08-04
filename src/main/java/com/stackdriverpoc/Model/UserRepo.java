package com.stackdriverpoc.Model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
