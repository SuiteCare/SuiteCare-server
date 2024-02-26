package com.suitecare.suitecare.api.recruitment.controller;

import com.suitecare.suitecare.api.recruitment.dto.PendingRecruitmentResponseDTO;
import com.suitecare.suitecare.api.recruitment.dto.RecruitmentRequestDTO;
import com.suitecare.suitecare.api.recruitment.dto.SearchedRecruitmentRequestDTO;
import com.suitecare.suitecare.api.recruitment.dto.SearchedRecruitmentResponseDTO;
import com.suitecare.suitecare.api.recruitment.service.RecruitmentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class RecruitmentController {

    @Autowired
    RecruitmentService recruitmentService;

    @PostMapping("/recruitment")
    public Integer createRecruitment(HttpServletRequest request, @RequestBody RecruitmentRequestDTO recruitmentRequestDTO) {
        String login_id = (String)request.getAttribute("id");
        return recruitmentService.createRecruitment(login_id, recruitmentRequestDTO);
    }

    @GetMapping("/search/recruitment")
    public List<SearchedRecruitmentResponseDTO> getSearchedRecruitment(SearchedRecruitmentRequestDTO requestDTO) {
        return recruitmentService.getSearchedRecruitment(requestDTO);
    }

    @GetMapping("/apply/{id}")
    public Integer applyRecruitment(HttpServletRequest request, @PathVariable Long id) {
        String login_id = (String) request.getAttribute("id");
        return recruitmentService.applyRecruitment(login_id, id);
    }

    @GetMapping("/pendingRecruitment")
    public List<PendingRecruitmentResponseDTO> getRecruitmentListById(HttpServletRequest request) {
        String login_id = (String)request.getAttribute("id");
        return recruitmentService.getRecruitmentListById(login_id);
    }
}
