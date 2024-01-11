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

    public Integer checkDuplicateID(String login_id) {
        return memberMapper.checkDuplicateID(login_id);
    }

    public Integer login(LoginRequestDTO loginRequestDTO) {
        LoginDTO loginDTO = memberMapper.getLoginInfoByLoginId(loginRequestDTO);

        if(passwordEncoder.matches(loginRequestDTO.getPassword(), loginDTO.getPassword())) {
            return loginDTO.getId();
        }
        return 0;
    }

    public MypageResponseDTO findMypageById(int id) {
        return memberMapper.findMypageById(id);
    }

    public Integer changePw(ChangePwRequestDTO changePwRequest) {
        String dbPassword = memberMapper.getPasswordById(changePwRequest.getLogin_id());
        if(passwordEncoder.matches(changePwRequest.getOriginPw(), dbPassword)) {
            if(changePwRequest.getNewPw().equals(changePwRequest.getNewPwCheck())) {
                changePwRequest.setNewPw(passwordEncoder.encode(changePwRequest.getNewPw()));
                return memberMapper.changePw(changePwRequest);
            }
        }

        return 0;
    }

    public Integer modify(ModifyRequestDTO modifyRequestDTO) {
        return memberMapper.modify(modifyRequestDTO);
    }
}
