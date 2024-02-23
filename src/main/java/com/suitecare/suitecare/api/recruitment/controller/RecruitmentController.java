package com.suitecare.suitecare.api.recruitment.controller;

import com.suitecare.suitecare.api.recruitment.dto.RecruitmentRequestDTO;
import com.suitecare.suitecare.api.recruitment.service.RecruitmentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class RecruitmentController {

    @Autowired
    RecruitmentService recruitmentService;

    @PostMapping("/recruitment")
    public int createRecruitment(HttpServletRequest request, @RequestBody RecruitmentRequestDTO recruitmentRequestDTO) {
        String login_id = (String)request.getAttribute("id");
        return recruitmentService.createRecruitment(login_id, recruitmentRequestDTO);
    }
}
