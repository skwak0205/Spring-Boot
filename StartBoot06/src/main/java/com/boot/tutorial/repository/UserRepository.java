package com.boot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.tutorial.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
