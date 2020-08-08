package com.project.mgmt.service.dto;

import com.project.mgmt.service.domain.Company;
import com.project.mgmt.service.domain.Party;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequest {

    private Long userId;
    private String userName;

    private Long partyId;

    private Long companyId;

    private Long typeId;
}
