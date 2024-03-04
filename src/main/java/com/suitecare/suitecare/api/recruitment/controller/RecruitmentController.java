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

    /* 공고 지원, 신청하기 */
    @PostMapping("apply")
    public Integer apply(@RequestBody ApplyInfoRequestDTO applyInfoRequestDTO) {
        return recruitmentService.apply(applyInfoRequestDTO);
    }

    /* 로그인ID에 따른 패밀리의 대기중인 공고리스트 불러오기 */
    @GetMapping("/pendingRecruitment")
    public List<PendingRecruitmentResponseDTO> getRecruitmentListById(HttpServletRequest request) {
        String login_id = (String)request.getAttribute("id");
        return recruitmentService.getRecruitmentListById(login_id);
    }

    /* [간병인] 로그인ID에 따른 내가 지원한 공고 리스트, 나에게 들어온 불러오기 */
    @GetMapping("/recruitment-list/{request_by}")
    public List<AppliedRecruitmentDTO> getAppliedRecruitmentListById(HttpServletRequest request, @PathVariable String request_by) {
        String login_id = (String)request.getAttribute("id");
        return recruitmentService.getAppliedRecruitmentListById(login_id, request_by);
    }
}
