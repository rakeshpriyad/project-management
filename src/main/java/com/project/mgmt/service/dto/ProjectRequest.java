package com.project.mgmt.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProjectRequest {

    private Long projectId;
    private String projectName;
    private Long companyId;
}
