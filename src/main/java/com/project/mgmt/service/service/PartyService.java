package com.project.mgmt.service.service;

import com.project.mgmt.service.domain.Party;
import com.project.mgmt.service.dto.PartyRequest;
import com.project.mgmt.service.repository.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.mgmt.service.utils.RepositoryUtils.getParty;

@Service
public class PartyService {

    private PartyRepository partyRepository;

    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public List<Party> getParties() {
        return partyRepository.findAll();
    }

    public Party getPartyById(Long id) {
        return partyRepository.findById(id).orElse(null);
    }

    public Optional<Party> save(PartyRequest request) {
        Party party = getParty(request.getPartyId(), request.getPartyName(), request.getPartyEmail());
        return Optional.ofNullable(partyRepository.save(party));
    }

    public Optional<Party> update(PartyRequest request) {
        Party party = getParty(request.getPartyId(), request.getPartyName(), request.getPartyEmail());
        return Optional.ofNullable(partyRepository.save(party));
    }

    public PartyRequest getPartyRequest(Long id, String partyName, String partyEmail) {
        return PartyRequest.builder().partyId(id).partyName(partyName).partyEmail(partyEmail).build();
    }
}

