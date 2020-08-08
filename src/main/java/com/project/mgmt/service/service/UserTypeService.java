package com.project.mgmt.service.service;

import com.project.mgmt.service.domain.UserType;
import com.project.mgmt.service.dto.UserTypeRequest;
import com.project.mgmt.service.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.mgmt.service.utils.RepositoryUtils.getUserType;

@Service
public class UserTypeService {

    private UserTypeRepository userTypeRepository;

    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public List<UserType> getUserTypes() {
        return userTypeRepository.findAll();
    }

    public UserType getUserTypeById(Long id) {
        return userTypeRepository.findById(id).orElse(null);
    }

    public Optional<UserType> save(UserTypeRequest request) {
        UserType userType = getUserType(request.getTypeId(), request.getType());
        return Optional.ofNullable(userTypeRepository.save(userType));
    }

    public Optional<UserType> update(UserTypeRequest request) {
        UserType userType = getUserType(request.getTypeId(), request.getType());
        return Optional.ofNullable(userTypeRepository.save(userType));
    }


    public UserTypeRequest getUserTypeRequest(Long typeId, String type) {
        return UserTypeRequest.builder().typeId(typeId).type(type).build();
    }
}

