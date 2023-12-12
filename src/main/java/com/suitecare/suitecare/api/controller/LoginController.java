package com.suitecare.suitecare.api.controller;

import com.suitecare.suitecare.api.service.LoginService;
import com.suitecare.suitecare.domain.LoginDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    LoginService loginService;

//    @GetMapping("/login")
//    public String login(){
//        return "family/login";
//    }

    @PostMapping("/login")
    public void login(HttpServletResponse response, @RequestBody LoginDTO loginDTO) {
        System.out.println(loginService.loginFamily(loginDTO));
        if(loginService.loginFamily(loginDTO) != null) {
            response.setStatus(200);
            response.addHeader("msg", "success");
        } else {
            response.addHeader("msg", "fail");
        }
    }
}
