package com.project.mgmt.service.controller;

import com.project.mgmt.service.domain.Party;
import com.project.mgmt.service.dto.PartyRequest;
import com.project.mgmt.service.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PartyController {

    private PartyService partyService;

    @Autowired
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping("/parties")
    public List<Party> getPartys() {
        return partyService.getParties();
    }

    @GetMapping("/parties/{id}")
    public Party getPartyById(@PathVariable("id") Long id) {
        return partyService.getPartyById(id);
    }

    @PostMapping("/parties")
    public Party save(@RequestBody PartyRequest party) {
        return partyService.save(party).get();
    }

    @PutMapping("/parties")
    public Party update(@RequestBody PartyRequest party) {
        return partyService.save(party).get();
    }
}

