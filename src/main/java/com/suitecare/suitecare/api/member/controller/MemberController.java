package com.suitecare.suitecare.api.member.controller;

import com.suitecare.suitecare.api.member.service.MemberService;
import com.suitecare.suitecare.api.member.dto.CreateMemberRequestDTO;
import com.suitecare.suitecare.api.member.dto.LoginRequestDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin()
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/family")
    public int createFamily(@RequestBody CreateMemberRequestDTO createMemberRequestDTO){
        return memberService.create(createMemberRequestDTO);
    }

    @GetMapping("/family")
    public int checkDuplicateID(@RequestParam String id){
        return memberService.checkDuplicateID(id);
    }

    @PostMapping("/login")
    public void login(HttpServletResponse response, @RequestBody LoginRequestDTO loginDTO) {
        if(memberService.login(loginDTO) != null) {
            response.setStatus(200);
            response.addHeader("msg", "success");
        } else {
            response.addHeader("msg", "fail");
        }
    }
}
