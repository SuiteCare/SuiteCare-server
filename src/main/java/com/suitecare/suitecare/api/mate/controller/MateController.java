package com.suitecare.suitecare.api.mate.controller;

import com.suitecare.suitecare.api.mate.dto.ProfileResponseDTO;
import com.suitecare.suitecare.api.mate.service.MateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/mate")
@CrossOrigin
public class MateController {

    @Autowired
    MateService mateService;

/*
    @PostMapping("/mate")
    public int createMate(@RequestBody CreateMemberRequestDTO createMemberRequestDTO){
        return mateService.create(createMemberRequestDTO);
    }
*/

    @GetMapping("/profile")
    public ProfileResponseDTO profile(@RequestParam int id) {
        return mateService.findProfileById(id);
    }
}
