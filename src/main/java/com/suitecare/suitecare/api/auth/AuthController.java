package com.suitecare.suitecare.api.auth;

import com.suitecare.suitecare.api.jwt.JwtUtils;
import com.suitecare.suitecare.api.member.dto.CreateMemberRequestDTO;
import com.suitecare.suitecare.api.member.dto.LoginDTO;
import com.suitecare.suitecare.api.member.dto.LoginRequestDTO;
import com.suitecare.suitecare.api.member.dto.LoginResponseDTO;
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
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDTO = null;

        try {
            LoginDTO loginDTO = memberService.login(loginRequestDTO);
            loginResponseDTO = new LoginResponseDTO(
                loginDTO.getId(),
                loginRequestDTO.getLogin_id(),
                new JwtUtils().createAccessToken(loginRequestDTO.getLogin_id(), loginRequestDTO.getRole()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("로그인 중 에러가 발생했습니다. null 을 return 합니다.");
        }

        return loginResponseDTO;
    }

    @PostMapping("/signup")
    public java.lang.Integer create(@RequestBody CreateMemberRequestDTO createMemberRequestDTO){
        System.out.println(createMemberRequestDTO);
        return memberService.create(createMemberRequestDTO);
    }

}
