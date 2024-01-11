package com.suitecare.suitecare.api.member.mapper;

import com.suitecare.suitecare.api.member.dto.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int create(CreateMemberRequestDTO createMemberRequestDTO);
    int checkDuplicateID(String id);
    MypageResponseDTO findMypageById(int id);
    int changePw(ChangePwRequestDTO changePwRequestDTO);
    int modify(ModifyRequestDTO modifyRequestDTO);
    LoginDTO getLoginInfoByLoginId(LoginRequestDTO loginDTO);
}
