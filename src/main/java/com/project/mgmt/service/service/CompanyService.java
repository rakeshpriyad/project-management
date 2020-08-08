package com.project.mgmt.service.service;

import com.project.mgmt.service.domain.Company;
import com.project.mgmt.service.dto.CompanyRequest;
import com.project.mgmt.service.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.mgmt.service.utils.RepositoryUtils.getCompany;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Optional<Company> save(CompanyRequest request) {
        Company company = getCompany(request.getId(), request.getCompanyName());
        return Optional.ofNullable(companyRepository.save(company));
    }

    public Optional<Company> update(CompanyRequest request) {
        Company company = getCompany(request.getId(), request.getCompanyName());
        return Optional.ofNullable(companyRepository.save(company));
    }

    public CompanyRequest getCompanyRequest(Long id, String companyName) {
        return CompanyRequest.builder().id(id).companyName(companyName).build();
    }
}

