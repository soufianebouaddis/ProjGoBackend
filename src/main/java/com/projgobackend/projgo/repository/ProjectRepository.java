package com.projgobackend.projgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projgobackend.projgo.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByTaskList_Id(Long taskId);
}