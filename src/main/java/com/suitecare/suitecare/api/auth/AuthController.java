package com.suitecare.suitecare.api.auth;

import com.suitecare.suitecare.api.member.dto.LoginRequestDTO;
import com.suitecare.suitecare.api.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin()
public class AuthController {

    @Autowired
    MemberService memberService;

    @PostMapping("/login")
    public Integer login(@RequestBody LoginRequestDTO loginDTO) {
        return memberService.login(loginDTO);
    }

}
