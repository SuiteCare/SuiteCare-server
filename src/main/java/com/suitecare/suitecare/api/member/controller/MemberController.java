package com.suitecare.suitecare.api.member.controller;

import com.suitecare.suitecare.api.member.dto.ChangePwResponseDTO;
import com.suitecare.suitecare.api.member.dto.MypageResponseDTO;
import com.suitecare.suitecare.api.member.service.MemberService;
import com.suitecare.suitecare.api.member.dto.CreateMemberRequestDTO;
import com.suitecare.suitecare.api.member.dto.LoginRequestDTO;
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
    public int checkDuplicateID(@RequestParam String id){
        return memberService.checkDuplicateID(id);
    }

    @PostMapping("/login")
    public Integer login(@RequestBody LoginRequestDTO loginDTO) {
        return memberService.login(loginDTO);
    }

    @GetMapping("/mypage")
    public MypageResponseDTO findInfoById(@RequestParam int id){
        return memberService.findMypageById(id);
    }

    @GetMapping("/changepw")
    public ChangePwResponseDTO changePw(@RequestParam int id){
        return memberService.ChangePw(id);
    }

}
