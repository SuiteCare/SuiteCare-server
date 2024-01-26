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
    public java.lang.Integer create(CreateMemberRequestDTO createMemberRequestDTO) {
        String encodedPasswd = passwordEncoder.encode(createMemberRequestDTO.getPassword());
        createMemberRequestDTO.setPassword(encodedPasswd);

        return memberMapper.create(createMemberRequestDTO);
    }

    public java.lang.Integer checkDuplicateID(String login_id) {
        return memberMapper.checkDuplicateID(login_id);
    }

    public LoginDTO login(LoginRequestDTO loginRequestDTO) throws IllegalArgumentException{
        // member 의 id, password 반환할 DTO
        LoginDTO loginDTO;

        // 계정 정보 존재 확인
        if((loginDTO = memberMapper.getAccountInfoForLogin(loginRequestDTO)) == null) {
            throw new IllegalArgumentException("No Account Info matches login_id");
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

    public MypageResponseDTO findMypageByLoginId(String login_id) {
        return memberMapper.findMypageByLoginId(login_id);
    }

    public Integer changePassword(ChangePasswordRequestDTO changePasswordRequestDTO) {
        String dbPassword = memberMapper.getPasswordById(changePasswordRequestDTO.getLogin_id());
        if(passwordEncoder.matches(changePasswordRequestDTO.getOriginPassword(), dbPassword)) {
            if(changePasswordRequestDTO.getNewPassword().equals(changePasswordRequestDTO.getNewPasswordCheck())) {
                changePasswordRequestDTO.setNewPassword(passwordEncoder.encode(changePasswordRequestDTO.getNewPassword()));
                return memberMapper.changePassword(changePasswordRequestDTO);
            }
        }

        return 0;
    }

    public java.lang.Integer modify(ModifyRequestDTO modifyRequestDTO) {
        return memberMapper.modify(modifyRequestDTO);
    }
}
