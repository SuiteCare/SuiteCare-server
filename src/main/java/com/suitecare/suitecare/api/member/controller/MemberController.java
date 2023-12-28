package com.suitecare.suitecare.api.member.controller;

import com.suitecare.suitecare.api.member.dto.*;
import com.suitecare.suitecare.api.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin()
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/member")
    public int create(@RequestBody CreateMemberRequestDTO createMemberRequestDTO){
        return memberService.create(createMemberRequestDTO);
    }

    @GetMapping("/member")
    public int checkDuplicateID(@RequestParam String login_id){
        return memberService.checkDuplicateID(login_id);
    }

    @PostMapping("/login")
    public Integer login(@RequestBody LoginRequestDTO loginDTO) {
        return memberService.login(loginDTO);
    }

    @GetMapping("/mypage")
    public MypageResponseDTO findInfoById(@RequestParam int id){
        return memberService.findMypageById(id);
    }

    @PostMapping("/changepw")
    public int changePw(@RequestBody ChangePwRequestDTO changePwRequestDTO){
        return memberService.changePw(changePwRequestDTO);
    }

    @PostMapping("/modify")
    public int modify(@RequestBody ModifyRequestDTO modifyRequestDTO){
        return memberService.modify(modifyRequestDTO);
    }


}
