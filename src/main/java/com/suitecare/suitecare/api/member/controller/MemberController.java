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
    public Integer checkDuplicateID(@RequestParam String id){
        return memberService.checkDuplicateID(id);
    }

    @GetMapping("/mypage")
    public MypageResponseDTO getMypageById(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        return memberService.findMypageById(id);
    }

    @PostMapping("/changepassword")
    public Integer changePassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO, HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        return memberService.changePassword(id, changePasswordRequestDTO);
    }

    @PatchMapping("/member")
    public Integer updateMember(@RequestBody UpdateMemberRequestDTO updateMemberRequestDTO, HttpServletRequest request) {
        String id = (String) request.getAttribute("id");
        return memberService.updateMember(id, updateMemberRequestDTO);
    }

    @PatchMapping("/role")
    public Integer updateRole(HttpServletRequest request) {
        String id = (String) request.getAttribute("id");
        return memberService.updateRole(id);
    }

}
