package com.project.mgmt.service.repository;
import com.project.mgmt.service.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
