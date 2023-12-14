package com.suitecare.suitecare.api.family.repository;

import com.suitecare.suitecare.api.family.domain.CreateFamilyDTO;
import com.suitecare.suitecare.api.family.domain.FamilyDTO;
import com.suitecare.suitecare.api.family.domain.LoginDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FamilyMapper {
    int createFamily(CreateFamilyDTO createFamilyDTO);
    FamilyDTO login(LoginDTO loginDTO);
    int checkDuplicateID(String id);
}
