package com.suitecare.suitecare.api.recruitment.controller;

import com.suitecare.suitecare.api.recruitment.dto.*;
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

    /* 공고 추가 정보 불러오기 */
    @GetMapping("/recruitment/{recruitment_id}/detail")
    public RecruitmentDetailDTO getRecruitmentById(@PathVariable Long recruitment_id) {
        return recruitmentService.getRecruitmentById(recruitment_id);
    }

    /* 공고에 대한 환자 정보 불러오기 */
    @GetMapping("/recruitment/{recruitment_id}/patient")
    public RecruitmentPatientResponseDTO getRecruitmentPatientById(@PathVariable Long recruitment_id) {
        return recruitmentService.getRecruitmentPatientById(recruitment_id);
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
