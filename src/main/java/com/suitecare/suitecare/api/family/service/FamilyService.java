package com.suitecare.suitecare.api.family.service;

import com.suitecare.suitecare.api.family.repository.FamilyMapper;
import com.suitecare.suitecare.api.family.dto.CreateFamilyRequestDTO;
import com.suitecare.suitecare.api.family.dto.FamilyResponseDTO;
import com.suitecare.suitecare.api.family.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyService {
    @Autowired
    FamilyMapper familyMapper;

    @Transactional
    public int createFamily(CreateFamilyRequestDTO createFamilyRequestDTO){
        return familyMapper.createFamily(createFamilyRequestDTO);
    }

    public int checkDuplicateID(String id){
        return familyMapper.checkDuplicateID(id);
    }

    public FamilyResponseDTO loginFamily(LoginRequestDTO login){
        return familyMapper.login(login);
    }
}