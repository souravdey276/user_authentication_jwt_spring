package com.stackroute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.model.User;

public interface AuthenticationRepository extends JpaRepository<User, String> {

}
