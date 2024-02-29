package com.suitecare.suitecare.api.recruitment.controller;

import com.suitecare.suitecare.api.mate_resume.dto.SearchedMateResponseDTO;
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

    /* 공고 등록 */
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

    /* 공고에 대한 지원자 리스트 불러오기 */
    @GetMapping("/recruitment/{recruitment_id}/applicants")
    public List<SearchedMateResponseDTO> getApplicantListById(@PathVariable Long recruitment_id) {
        return recruitmentService.getApplicantListById(recruitment_id);
    }

    /* 검색 조건에 따른 공고 검색 */
    @GetMapping("/search/recruitment")
    public List<SearchedRecruitmentResponseDTO> getSearchedRecruitment(SearchedRecruitmentRequestDTO requestDTO) {
        return recruitmentService.getSearchedRecruitment(requestDTO);
    }

    /* 간병인의 공고 지원하기 */
    @PostMapping("mate/apply")
    public Integer applyToRecruitment(HttpServletRequest request, @RequestParam Long recruitment_id) {
        String login_id = (String) request.getAttribute("id");
        return recruitmentService.applyToRecruitment(login_id, recruitment_id);
    }

    /* 보호자의 간병인 신청하기 */
    @PostMapping("family/apply")
    public Integer applyToMate(@RequestBody ApplyToMateRequestDTO applyToMateRequestDTO) {
        return recruitmentService.applyToMate(applyToMateRequestDTO);
    }

    /* 로그인ID에 따른 패밀리의 대기중인 공고리스트 불러오기 */
    @GetMapping("/pendingRecruitment")
    public List<PendingRecruitmentResponseDTO> getRecruitmentListById(HttpServletRequest request) {
        String login_id = (String)request.getAttribute("id");
        return recruitmentService.getRecruitmentListById(login_id);
    }

    /* 로그인ID(M)에 따른 내가 지원한 공고 리스트 불러오기 */
    @GetMapping("/appliedRecruitment")
    public List<AppliedRecruitmentDTO> getAppliedRecruitmentListById(HttpServletRequest request) {
        String login_id = (String)request.getAttribute("id");
        return recruitmentService.getAppliedRecruitmentListById(login_id);
    }
}
