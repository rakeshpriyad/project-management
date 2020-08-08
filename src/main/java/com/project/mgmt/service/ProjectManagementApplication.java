package com.project.mgmt.service;


import com.project.mgmt.service.domain.*;
import com.project.mgmt.service.dto.*;
import com.project.mgmt.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2WebMvc
public class ProjectManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private PartyService partyService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTypeService userTypeService;


    @Bean
    public void setup(){
        CompanyRequest cr= companyService.getCompanyRequest(1l,"MyCompany");
        Optional<Company> c =companyService.save(cr);
        ProjectRequest pr = projectService.getProjectRequest(1L, "P1", c.get().getId());
        Optional<Project> project = projectService.save(pr);
        PartyRequest partyRequest = partyService.getPartyRequest(1l, "Party1", "party@project.com");
        Optional<Party>  party = partyService.save(partyRequest);
        TaskRequest taskRequest = taskService.getTaskRequest(1l, "Mytask", party.get().getPartyId());
        Optional<Task> task = taskService.save(taskRequest);

        UserTypeRequest cReq = userTypeService.getUserTypeRequest(1l, "company");
        Optional<UserType> companyT = userTypeService.save(cReq);
        UserRequest companyUserReq = userService.getUserRequest(1l,"KISHORE", c.get().getId(),party.get().getPartyId(), companyT.get().getTypeId() );
        userService.save(companyUserReq);
        UserTypeRequest oReq = userTypeService.getUserTypeRequest(1l, "other");
        Optional<UserType> ohterT = userTypeService.save(cReq);
        UserRequest otherUserReq = userService.getUserRequest(2l,"KISHORE1", c.get().getId(),party.get().getPartyId(), ohterT.get().getTypeId() );
        userService.save(otherUserReq);
    }




}
