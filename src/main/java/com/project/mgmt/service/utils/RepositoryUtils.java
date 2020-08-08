package com.project.mgmt.service.utils;


import com.project.mgmt.service.domain.*;

public class RepositoryUtils {

    public static Company getCompany(Long id, String companyName) {
        return Company.builder().id(id).companyName(companyName).build();
    }

    public static Party getParty(Long id, String partyName, String partyEmail) {
        return Party.builder().partyId(id).partyName(partyName).partyEmail(partyEmail).build();
    }

    public static Project getProject(Long projectId, String projectName, Company company) {
        return Project.builder().projectId(projectId).projectName(projectName).company(company).build();
    }

    public static Task getTask(Long taskId, String taskName, Party party) {
        return Task.builder().taskId(taskId).taskName(taskName).party(party).build();
    }

    public static User getUser(Long userId, String userName, Company company, Party party, UserType type) {
        return User.builder().userId(userId).userName(userName).company(company).party(party).type(type).build();
    }

    public static UserType getUserType(Long typeId, String type) {
        return UserType.builder().typeId(typeId).type(type).build();
    }

}
