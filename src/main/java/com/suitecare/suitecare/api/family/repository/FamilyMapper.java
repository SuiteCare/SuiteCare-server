package com.suitecare.suitecare.api.family.repository;

import com.suitecare.suitecare.api.family.dto.CreateFamilyRequestDTO;
import com.suitecare.suitecare.api.family.dto.FamilyResponseDTO;
import com.suitecare.suitecare.api.family.dto.LoginRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FamilyMapper {
    int createFamily(CreateFamilyRequestDTO createFamilyRequestDTO);
    FamilyResponseDTO login(LoginRequestDTO loginDTO);
    int checkDuplicateID(String id);
}
