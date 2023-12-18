package com.suitecare.suitecare.api.family.controller;

import com.suitecare.suitecare.api.family.service.FamilyService;
import com.suitecare.suitecare.api.family.dto.CreateFamilyRequestDTO;
import com.suitecare.suitecare.api.family.dto.LoginRequestDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin()
public class FamilyController {
    @Autowired
    FamilyService familyService;

    @PostMapping("/family")
    public int createFamily(@RequestBody CreateFamilyRequestDTO createFamilyRequestDTO){
        return familyService.create(createFamilyRequestDTO);
    }

    @GetMapping("/family")
    public int checkDuplicateID(@RequestParam String id){
        return familyService.checkDuplicateID(id);
    }

    @PostMapping("/login")
    public void login(HttpServletResponse response, @RequestBody LoginRequestDTO loginDTO) {
        if(familyService.login(loginDTO) != null) {
            response.setStatus(200);
            response.addHeader("msg", "success");
        } else {
            response.addHeader("msg", "fail");
        }
    }
}
