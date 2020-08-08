package com.project.mgmt.service.service;

import com.project.mgmt.service.domain.Company;
import com.project.mgmt.service.domain.Party;
import com.project.mgmt.service.domain.User;
import com.project.mgmt.service.domain.UserType;
import com.project.mgmt.service.dto.UserRequest;
import com.project.mgmt.service.repository.CompanyRepository;
import com.project.mgmt.service.repository.PartyRepository;
import com.project.mgmt.service.repository.UserRepository;
import com.project.mgmt.service.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.mgmt.service.utils.RepositoryUtils.getUser;

@Service
public class UserService {

    private UserRepository userRepository;
    private PartyRepository partyRepository;
    private UserTypeRepository typeRepository;
    private  CompanyRepository companyRepository;

    public UserService(CompanyRepository companyRepository, UserRepository userRepository, PartyRepository partyRepository, UserTypeRepository typeRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.partyRepository = partyRepository;
        this.typeRepository = typeRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Optional<User> save(UserRequest request) {
        Optional<Company> company = companyRepository.findById(request.getCompanyId());
        Optional<Party> party = partyRepository.findById(request.getPartyId());
        Optional<UserType> type = typeRepository.findById(request.getTypeId());
        User user = getUser(request.getUserId(), request.getUserName(), company.get(), party.get(), type.get());
        return Optional.ofNullable(userRepository.save(user));
    }

    public Optional<User> update(UserRequest request) {
        Optional<Company> company = companyRepository.findById(request.getCompanyId());
        Optional<Party> party = partyRepository.findById(request.getPartyId());
        Optional<UserType> type = typeRepository.findById(request.getCompanyId());
        User user = getUser(request.getUserId(), request.getUserName(), company.get(), party.get(), type.get());
        return Optional.ofNullable(userRepository.save(user));
    }


    public   UserRequest getUserRequest(Long userId, String userName, Long companyId, Long partyId, Long typeId){
        return UserRequest.builder().userId(userId).userName(userName).companyId(companyId).partyId(partyId).typeId(typeId).build();
    }
}

