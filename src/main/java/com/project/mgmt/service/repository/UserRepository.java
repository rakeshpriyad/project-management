package com.project.mgmt.service.repository;

import com.project.mgmt.service.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
