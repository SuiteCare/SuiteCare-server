package com.suitecare.suitecare.api.member.mapper;

import com.suitecare.suitecare.api.member.dto.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Integer create(CreateMemberRequestDTO createMemberRequestDTO);
    Integer checkDuplicateID(String id);
    MypageResponseDTO findMypageById(int id);
    Integer changePw(ChangePwRequestDTO changePwRequestDTO);
    Integer modify(ModifyRequestDTO modifyRequestDTO);
    LoginDTO getLoginInfoByLoginId(LoginRequestDTO loginDTO);
}
