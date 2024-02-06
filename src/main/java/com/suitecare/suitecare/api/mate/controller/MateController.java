package com.suitecare.suitecare.api.mate.controller;

import com.suitecare.suitecare.api.mate.dto.ResumeRequestDTO;
import com.suitecare.suitecare.api.mate.dto.ResumeResponseDTO;
import com.suitecare.suitecare.api.mate.service.MateService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/mate")
@CrossOrigin
public class MateController {

    @Autowired
    MateService mateService;

    @GetMapping("/resume")
    public ResumeResponseDTO resume(HttpServletRequest request) {
        String login_id = (String) request.getAttribute("login_id");
        return mateService.findResumeById(login_id);
    }

    /* 간병인 이력서 등록 */
    @PostMapping("/resume")
    public int createResume(HttpServletRequest request, @RequestBody ResumeRequestDTO resumeRequestDTO) {
        String login_id = (String) request.getAttribute("login_id");
        return mateService.createResume(login_id, resumeRequestDTO);
    }
}
