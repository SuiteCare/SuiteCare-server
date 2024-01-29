package com.suitecare.suitecare.api.member.service;

import com.suitecare.suitecare.api.member.dto.*;
import com.suitecare.suitecare.api.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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

    public Integer checkDuplicateID(String login_id) {
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
        return memberMapper.getMypageByLoginId(login_id);
    }

    public Integer changePassword(String login_id, ChangePasswordRequestDTO changePasswordRequestDTO) {
        String dbPassword = memberMapper.getPasswordById(login_id);
        if(passwordEncoder.matches(changePasswordRequestDTO.getOriginPassword(), dbPassword)) {
            if(changePasswordRequestDTO.getNewPassword().equals(changePasswordRequestDTO.getNewPasswordCheck())) {
                String newPassword = passwordEncoder.encode(changePasswordRequestDTO.getNewPassword());
                return memberMapper.changePassword(login_id, newPassword);
            }
        }

        return 0;
    }

    public Integer updateMember(String login_id, UpdateMemberRequestDTO updateMemberRequestDTO) {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("login_id", login_id);
        parameterMap.put("updateMemberRequestDTO", updateMemberRequestDTO);

        return memberMapper.updateMember(parameterMap);
    }
}
