package com.projgobackend.projgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projgobackend.projgo.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}