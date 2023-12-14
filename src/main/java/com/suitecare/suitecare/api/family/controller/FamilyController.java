package com.suitecare.suitecare.api.family.controller;

import com.suitecare.suitecare.api.family.service.FamilyService;
import com.suitecare.suitecare.api.family.domain.CreateFamilyDTO;
import com.suitecare.suitecare.api.family.domain.LoginDTO;
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
    public int createFamily(@RequestBody CreateFamilyDTO createFamilyDTO){
        return familyService.createFamily(createFamilyDTO);
    }

    @GetMapping("/family")
    public int checkDuplicateID(@RequestParam String id){
        return familyService.checkDuplicateID(id);
    }

    @PostMapping("/login")
    public void login(HttpServletResponse response, @RequestBody LoginDTO loginDTO) {
        System.out.println(familyService.loginFamily(loginDTO));
        if(familyService.loginFamily(loginDTO) != null) {
            response.setStatus(200);
            response.addHeader("msg", "success");
        } else {
            response.addHeader("msg", "fail");
        }
    }
}
