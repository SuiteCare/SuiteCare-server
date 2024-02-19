package com.suitecare.suitecare.api.member.mapper;

import com.suitecare.suitecare.api.member.dto.*;
import com.suitecare.suitecare.api.member.dto.LoginDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapper {
    /* 회원가입 관련 로직 */
    Integer create(CreateMemberRequestDTO createMemberRequestDTO);
    Integer checkDuplicateID(String id);

    /* 로그인 관련 로직 */
    LoginDTO getAccountInfoForLogin(LoginRequestDTO loginRequestDTO);

    /* 패스워드 변경 관련 로직 */
    String getPasswordById(String id);
    Integer changePassword(String id, String newPassword);

    MypageResponseDTO getMypageById(String id);
    Integer updateMember(Map<String, Object> parameterMap);
}
