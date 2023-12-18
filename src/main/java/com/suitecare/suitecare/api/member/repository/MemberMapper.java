package com.suitecare.suitecare.api.member.repository;

import com.suitecare.suitecare.api.member.dto.CreateMemberRequestDTO;
import com.suitecare.suitecare.api.member.dto.MemberResponseDTO;
import com.suitecare.suitecare.api.member.dto.LoginRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int createFamily(CreateMemberRequestDTO createMemberRequestDTO);
    MemberResponseDTO login(LoginRequestDTO loginDTO);
    int checkDuplicateID(String id);
}
