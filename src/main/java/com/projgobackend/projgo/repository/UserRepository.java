package com.projgobackend.projgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projgobackend.projgo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}