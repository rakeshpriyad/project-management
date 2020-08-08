package com.project.mgmt.service.dto;

import com.project.mgmt.service.domain.Party;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaskRequest {

    private Long taskId;
    private String taskName;

    private Long partyId;
}
