package com.project.mgmt.service.service;

import com.project.mgmt.service.domain.Company;
import com.project.mgmt.service.domain.Project;
import com.project.mgmt.service.dto.ProjectRequest;
import com.project.mgmt.service.repository.CompanyRepository;
import com.project.mgmt.service.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.mgmt.service.utils.RepositoryUtils.getProject;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private CompanyRepository companyRepository;
    public ProjectService(ProjectRepository projectRepository, CompanyRepository companyRepository) {
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Optional<Project> save(ProjectRequest request) {
        Optional<Company> company = companyRepository.findById(request.getCompanyId());
        Project project = getProject(request.getProjectId(), request.getProjectName(), company.get());
        return Optional.ofNullable(projectRepository.save(project));
    }

    public Optional<Project> update(ProjectRequest request) {
        Optional<Company> company = companyRepository.findById(request.getCompanyId());
        Project project = getProject(request.getProjectId(), request.getProjectName(), company.get());
        return Optional.ofNullable(projectRepository.save(project));
    }

    public   ProjectRequest getProjectRequest(Long id, String projectName, Long companyId){
        return ProjectRequest.builder().projectId(id).projectName(projectName).companyId(companyId).build();
    }
}

