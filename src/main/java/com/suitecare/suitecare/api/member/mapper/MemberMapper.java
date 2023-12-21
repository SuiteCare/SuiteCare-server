package com.suitecare.suitecare.api.member.mapper;

import com.suitecare.suitecare.api.member.dto.CreateMemberRequestDTO;
import com.suitecare.suitecare.api.member.dto.MemberResponseDTO;
import com.suitecare.suitecare.api.member.dto.LoginRequestDTO;
import com.suitecare.suitecare.api.member.dto.MypageResponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int createFamily(CreateMemberRequestDTO createMemberRequestDTO);
    MemberResponseDTO login(LoginRequestDTO loginDTO);
    int checkDuplicateID(String id);
    MypageResponseDTO findMypageById(int id);
}
