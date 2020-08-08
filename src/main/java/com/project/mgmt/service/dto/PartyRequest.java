package com.project.mgmt.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PartyRequest {

    private Long partyId;
    private String partyName;
    private String partyEmail;
}
