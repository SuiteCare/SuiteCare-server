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

    /* 공고에 대한 간병인 리스트 불러오기 */
    @GetMapping("/recruitment/{recruitment_id}/{request_by}")
    public List<ApplicantsMateDTO> getApplicantListById(@PathVariable Long recruitment_id, @PathVariable String request_by) {
        return recruitmentService.getApplicantListById(recruitment_id, request_by);
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

    /* [간병인] 로그인ID에 따른 내가 지원한 공고 리스트 불러오기 */
    @GetMapping("/apply/recruitment-list")
    public List<AppliedRecruitmentDTO> getAppliedRecruitmentListById(HttpServletRequest request) {
        String login_id = (String)request.getAttribute("id");
        return recruitmentService.getAppliedRecruitmentListById(login_id);
    }

    /* [간병인] 로그인ID에 따른 나에게 들어온 공고 리스트 불러오기 */
    @GetMapping("/offer/recruitment-list")
    public List<AppliedRecruitmentDTO> getOfferedRecruitmentListById(HttpServletRequest request) {
        String login_id = (String)request.getAttribute("id");
        return recruitmentService.getOfferedRecruitmentListById(login_id);
    }

    /* [간병인] 지원 취소하기 */
    @DeleteMapping("/applicant/{recruitment_id}")
    public Integer deleteApplicant(HttpServletRequest request, @PathVariable Long recruitment_id) {
        String login_id = (String)request.getAttribute("id");
        return recruitmentService.deleteApplicant(login_id, recruitment_id);
    }
}
