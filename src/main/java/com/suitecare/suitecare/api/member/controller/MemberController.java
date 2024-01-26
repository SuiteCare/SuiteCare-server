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
    public Integer create(@RequestBody CreateMemberRequestDTO createMemberRequestDTO){
        System.out.println(createMemberRequestDTO);
        return memberService.create(createMemberRequestDTO);
    }

    @GetMapping("/member")
    public Integer checkDuplicateID(@RequestParam String login_id){
        return memberService.checkDuplicateID(login_id);
    }

    @GetMapping("/mypage")
    public MypageResponseDTO findInfoById(@RequestParam Long id){
        return memberService.findMypageById(id);
    }

    @PostMapping("/changepw")
    public Integer changePassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO){
        return memberService.changePassword(changePasswordRequestDTO);
    }

    @PostMapping("/modify")
    public Integer modify(@RequestBody ModifyRequestDTO modifyRequestDTO){
        return memberService.modify(modifyRequestDTO);
    }


}
