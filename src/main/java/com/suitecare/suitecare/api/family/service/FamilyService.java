package com.suitecare.suitecare.api.family.service;

import com.suitecare.suitecare.api.family.repository.FamilyMapper;
import com.suitecare.suitecare.api.family.domain.CreateFamilyDTO;
import com.suitecare.suitecare.api.family.domain.FamilyDTO;
import com.suitecare.suitecare.api.family.domain.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyService {
    @Autowired
    FamilyMapper familyMapper;

    @Transactional
    public int createFamily(CreateFamilyDTO createFamilyDTO){
        return familyMapper.createFamily(createFamilyDTO);
    }

    public int checkDuplicateID(String id){
        return familyMapper.checkDuplicateID(id);
    }

    public FamilyDTO loginFamily(LoginDTO login){
        return familyMapper.login(login);
    }
}