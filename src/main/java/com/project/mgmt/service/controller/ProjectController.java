package com.project.mgmt.service.controller;

import com.project.mgmt.service.domain.Project;
import com.project.mgmt.service.dto.ProjectRequest;
import com.project.mgmt.service.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/projects/{id}")
    public Project getProjectById(@PathVariable("id") Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/projects")
    public Project save(@RequestBody ProjectRequest project) {
        return projectService.save(project).get();
    }

    @PutMapping("/projects")
    public Project update(@RequestBody ProjectRequest project) {
        return projectService.save(project).get();
    }
}

