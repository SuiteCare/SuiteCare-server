package com.suitecare.suitecare.api.member.service;

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

    public MypageResponseDTO findMypageById(String id) {
        return memberMapper.getMypageById(id);
    }

    public Integer changePassword(String id, ChangePasswordRequestDTO changePasswordRequestDTO) {
        String dbPassword = memberMapper.getPasswordById(id);
        if(passwordEncoder.matches(changePasswordRequestDTO.getOriginPassword(), dbPassword)) {
            if(changePasswordRequestDTO.getNewPassword().equals(changePasswordRequestDTO.getNewPasswordCheck())) {
                String newPassword = passwordEncoder.encode(changePasswordRequestDTO.getNewPassword());
                return memberMapper.changePassword(id, newPassword);
            }
        }

        return 0;
    }

    public Integer updateMember(String id, UpdateMemberRequestDTO updateMemberRequestDTO) {
        return memberMapper.updateMember(id, updateMemberRequestDTO);
    }

    public Integer updateRole(String id) {
        return memberMapper.updateRole(id);
    }
}
