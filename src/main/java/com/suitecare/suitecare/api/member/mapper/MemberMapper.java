package com.suitecare.suitecare.api.member.mapper;

import com.suitecare.suitecare.api.member.dto.*;
import com.suitecare.suitecare.api.reservation.dto.ApplyReservationRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Integer create(CreateMemberRequestDTO createMemberRequestDTO);
    Integer checkDuplicateID(String id);
    MypageResponseDTO findMypageById(int id);
    String getPasswordById(Integer id);
    Integer changePassword(ChangePasswordRequestDTO changePasswordRequestDTO);
    Integer modify(ModifyRequestDTO modifyRequestDTO);
    LoginDTO getLoginInfoByLoginId(LoginRequestDTO loginDTO);
}
