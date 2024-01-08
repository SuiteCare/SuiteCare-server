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
    public int create(CreateMemberRequestDTO createMemberRequestDTO) {
        String encoderPwd = passwordEncoder.encode(createMemberRequestDTO.getPassword());
        createMemberRequestDTO.setPassword(encoderPwd);

        return memberMapper.create(createMemberRequestDTO);
    }

    public int checkDuplicateID(String login_id) {
        return memberMapper.checkDuplicateID(login_id);
    }

    public Integer login(LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDTO = memberMapper.login(loginRequestDTO);

        if(passwordEncoder.matches(loginRequestDTO.getPassword(), loginResponseDTO.getPassword())) {
            return loginResponseDTO.getId();
        }
        return 0;
    }

    public MypageResponseDTO findMypageById(int id) {
        return memberMapper.findMypageById(id);
    }

    public int changePw(ChangePwRequestDTO changePwRequest) {
        return memberMapper.changePw(changePwRequest); }

    public int modify(ModifyRequestDTO modifyRequestDTO) {
        return memberMapper.modify(modifyRequestDTO);
    }
}
