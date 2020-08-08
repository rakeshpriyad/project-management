package com.project.mgmt.service.controller;

import com.project.mgmt.service.domain.Company;
import com.project.mgmt.service.dto.CompanyRequest;
import com.project.mgmt.service.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("/companies/{id}")
    public Company getCompanyById(@PathVariable("id") Long id) {
        return companyService.getCompanyById(id);
    }

    @PostMapping("/companies")
    public Company save(@RequestBody CompanyRequest company) {
        return companyService.save(company).get();
    }

    @CrossOrigin
    @PutMapping("/companies")
    public Company update(@RequestBody CompanyRequest company) {
        return companyService.save(company).get();
    }


}

