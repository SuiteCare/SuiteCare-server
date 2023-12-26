package com.suitecare.suitecare.api.member.service;

import com.suitecare.suitecare.api.member.dto.MypageResponseDTO;
import com.suitecare.suitecare.api.member.mapper.MemberMapper;
import com.suitecare.suitecare.api.member.dto.CreateMemberRequestDTO;
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
        return memberMapper.create(createMemberRequestDTO);
    }

    public int checkDuplicateID(String login_id){
        return memberMapper.checkDuplicateID(login_id);
    }

    public Integer login(LoginRequestDTO loginRequestDTO){
        return memberMapper.login(loginRequestDTO);
    }

    public MypageResponseDTO findMypageById(int id){
        return memberMapper.findMypageById(id);
    }
}