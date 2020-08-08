package com.project.mgmt.service.repository;

import com.project.mgmt.service.domain.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
