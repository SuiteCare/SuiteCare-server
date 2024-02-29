package com.suitecare.suitecare.api.member.mapper;

import com.suitecare.suitecare.api.member.dto.*;
import com.suitecare.suitecare.api.member.dto.LoginDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    /* 회원가입 관련 로직 */
    Integer create(CreateMemberRequestDTO createMemberRequestDTO);
    Integer checkDuplicateID(String id);

    /* 로그인 관련 로직 */
    LoginDTO getAccountInfoForLogin(LoginRequestDTO loginRequestDTO);

    /* 패스워드 변경 관련 로직 */
    String getPasswordById(String id);
    Integer changePassword(@Param("login_id") String login_id, @Param("newPassword") String newPassword);

    MypageResponseDTO getMypageById(String login_id);
    Integer updateMember(@Param("login_id") String login_id, @Param("updateMemberRequestDTO") UpdateMemberRequestDTO updateMemberRequestDTO);
    Integer updateRole(String login_id);
}
