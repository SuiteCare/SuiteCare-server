package com.suitecare.suitecare.api.member.mapper;

import com.suitecare.suitecare.api.member.dto.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Integer create(CreateMemberRequestDTO createMemberRequestDTO);
    Integer checkDuplicateID(String id);
    MypageResponseDTO findMypageById(Long id);
    String getPasswordById(Long id);
    Integer changePassword(ChangePasswordRequestDTO changePasswordRequestDTO);
    Integer modify(ModifyRequestDTO modifyRequestDTO);
    LoginDTO getLoginInfoByLoginId(LoginRequestDTO loginDTO);
}
