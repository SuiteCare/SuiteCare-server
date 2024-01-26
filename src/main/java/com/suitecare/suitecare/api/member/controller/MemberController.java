package com.suitecare.suitecare.api.member.controller;

import com.suitecare.suitecare.api.member.dto.*;
import com.suitecare.suitecare.api.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin()
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/check/id")
    public Integer checkDuplicateID(@RequestParam String login_id){
        System.out.println("checkdupid method started");
        return memberService.checkDuplicateID(login_id);
    }

    @GetMapping("/mypage")
    public MypageResponseDTO getMypageByLoginId(HttpServletRequest request){
        String login_id = (String) request.getAttribute("login_id");
        return memberService.findMypageByLoginId(login_id);
    }

    @PostMapping("/changepw")
    public Integer changePassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO){
        return memberService.changePassword(changePasswordRequestDTO);
    }

    @PatchMapping("/member")
    public Integer updateMember(@RequestBody UpdateMemberRequestDTO updateMemberRequestDTO, HttpServletRequest request) {
        String login_id = (String) request.getAttribute("login_id");
        return memberService.updateMember(login_id, updateMemberRequestDTO);
    }


}
