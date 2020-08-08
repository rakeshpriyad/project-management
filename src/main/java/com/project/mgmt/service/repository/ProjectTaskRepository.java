package com.project.mgmt.service.repository;

import com.project.mgmt.service.domain.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {
}
