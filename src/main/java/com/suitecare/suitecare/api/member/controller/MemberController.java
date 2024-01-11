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

    @GetMapping("/member")
    public Integer checkDuplicateID(@RequestParam String login_id){
        return memberService.checkDuplicateID(login_id);
    }

    @GetMapping("/mypage")
    public MypageResponseDTO findInfoById(@RequestParam int id){
        return memberService.findMypageById(id);
    }

    @PostMapping("/changepw")
    public Integer changePw(@RequestBody ChangePwRequestDTO changePwRequestDTO){
        return memberService.changePw(changePwRequestDTO);
    }

    @PostMapping("/modify")
    public Integer modify(@RequestBody ModifyRequestDTO modifyRequestDTO){
        return memberService.modify(modifyRequestDTO);
    }


}
