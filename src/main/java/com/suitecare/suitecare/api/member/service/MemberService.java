package com.suitecare.suitecare.api.member.service;

import com.suitecare.suitecare.api.member.repository.MemberMapper;
import com.suitecare.suitecare.api.member.dto.CreateMemberRequestDTO;
import com.suitecare.suitecare.api.member.dto.MemberResponseDTO;
import com.suitecare.suitecare.api.member.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;

    @Transactional
    public int create(CreateMemberRequestDTO createMemberRequestDTO){
        return memberMapper.createFamily(createMemberRequestDTO);
    }

    public int checkDuplicateID(String login_id){
        return memberMapper.checkDuplicateID(login_id);
    }

    public MemberResponseDTO login(LoginRequestDTO loginRequestDTO){
        return memberMapper.login(loginRequestDTO);
    }
}