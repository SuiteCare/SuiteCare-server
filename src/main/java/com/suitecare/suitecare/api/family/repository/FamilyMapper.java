package com.suitecare.suitecare.api.family.repository;

import com.suitecare.suitecare.api.family.dto.CreateFamilyDTO;
import com.suitecare.suitecare.api.family.dto.FamilyDTO;
import com.suitecare.suitecare.api.family.dto.LoginDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FamilyMapper {
    int createFamily(CreateFamilyDTO createFamilyDTO);
    FamilyDTO login(LoginDTO loginDTO);
    int checkDuplicateID(String id);
}
