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

    @GetMapping("/resume")
    public ProfileResponseDTO profile(@RequestParam Long id) {
        return mateService.findResumeById(id);
    }
}
