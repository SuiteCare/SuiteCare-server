package com.suitecare.suitecare.api.member.mapper;

import com.suitecare.suitecare.api.member.dto.*;
import com.suitecare.suitecare.api.member.dto.LoginDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    /* 회원가입 관련 로직 */
    Integer create(CreateMemberRequestDTO createMemberRequestDTO);
    Integer checkDuplicateID(String id);

    /* 로그인 관련 로직 */
    LoginDTO getAccountInfoForLogin(LoginRequestDTO loginRequestDTO);

    MypageResponseDTO findMypageById(int id);
    Integer changePw(ChangePwRequestDTO changePwRequestDTO);
    Integer modify(ModifyRequestDTO modifyRequestDTO);
}
