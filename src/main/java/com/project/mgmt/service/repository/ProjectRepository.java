package com.project.mgmt.service.repository;

import com.project.mgmt.service.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
