package com.project.mgmt.service.repository;

import com.project.mgmt.service.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
