package com.suitecare.suitecare.api.member.service;

import com.suitecare.suitecare.api.custom.exception.UserException;
import com.suitecare.suitecare.api.member.dto.*;
import com.suitecare.suitecare.api.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public Integer create(CreateMemberRequestDTO createMemberRequestDTO) {
        String encodedPasswd = passwordEncoder.encode(createMemberRequestDTO.getPassword());
        createMemberRequestDTO.setPassword(encodedPasswd);

        return memberMapper.create(createMemberRequestDTO);
    }

    public Integer checkDuplicateID(String id) {
        return memberMapper.checkDuplicateID(id);
    }

    public LoginDTO login(LoginRequestDTO loginRequestDTO) throws IllegalArgumentException{
        // member 의 id, password 반환할 DTO
        LoginDTO loginDTO;

        // 계정 정보 존재 확인
        if((loginDTO = memberMapper.getAccountInfoForLogin(loginRequestDTO)) == null) {
            throw new IllegalArgumentException("No Account Info matches Id");
        }

        // 패스워드 일치 여부 확인
        if(!passwordEncoder.matches(loginRequestDTO.getPassword(), loginDTO.getPassword())) {
            throw new IllegalArgumentException("Password mismatched.");
        }

        // 권한 일치 여부 확인
        if(!(loginRequestDTO.getRole().equals(loginDTO.getRole()) || loginDTO.getRole().equals("A"))) {
            throw new IllegalArgumentException("Role mismatched.");
        }

        return loginDTO;
    }

    public MypageResponseDTO getMypageById(String login_id) {
        return memberMapper.getMypageById(login_id);
    }

    public Integer changePassword(String login_id, ChangePasswordRequestDTO changePasswordRequestDTO) {
        String dbPassword = memberMapper.getPasswordById(login_id);

        // 현재 비밀번호 일치하는지 확인
        if(passwordEncoder.matches(changePasswordRequestDTO.getOriginPassword(), dbPassword)) {
            // 기존 비밀번호와 변경 비밀번호가 동일한 경우
            if(changePasswordRequestDTO.getOriginPassword().equals(changePasswordRequestDTO.getNewPassword())) {
                throw new UserException.SamePasswordException("현재 사용 중인 비밀번호는 사용할 수 없습니다.");
            }

            if(changePasswordRequestDTO.getNewPassword().equals(changePasswordRequestDTO.getNewPasswordCheck())) { // 새 비밀번호 두개 일치하는지 여부 확인
                String newPassword = passwordEncoder.encode(changePasswordRequestDTO.getNewPassword());
                return memberMapper.changePassword(login_id, newPassword);
            }
        } else {
            throw new UserException.NotMatchPasswordException("현재 비밀번호가 일치하지 않습니다.");
        }

        return 0;
    }

    public Integer updateMember(String login_id, UpdateMemberRequestDTO updateMemberRequestDTO) {
        return memberMapper.updateMember(login_id, updateMemberRequestDTO);
    }

    public Integer updateRole(String login_id) {
        return memberMapper.updateRole(login_id);
    }
}
