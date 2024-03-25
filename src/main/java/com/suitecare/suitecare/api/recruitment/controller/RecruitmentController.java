package com.suitecare.suitecare.api.recruitment.controller;

import com.suitecare.suitecare.api.custom.format.ResponseForm;
import com.suitecare.suitecare.api.recruitment.dto.*;
import com.suitecare.suitecare.api.recruitment.service.RecruitmentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class RecruitmentController {

    @Autowired
    RecruitmentService recruitmentService;

    /* 공고 등록 */
    @PostMapping("/recruitment")
    public ResponseEntity<ResponseForm> createRecruitment(HttpServletRequest request, @RequestBody RecruitmentRequestDTO recruitmentRequestDTO) {
        ResponseForm responseForm;
        String login_id = (String)request.getAttribute("id");

        int result = recruitmentService.createRecruitment(login_id, recruitmentRequestDTO);

        if(result != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("공고 등록이 완료되었습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("공고 등록이 실패했습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 공고 추가 정보 불러오기 */
    @GetMapping("/recruitment/{recruitment_id}/detail")
    public ResponseEntity<ResponseForm> getRecruitmentById(@PathVariable Long recruitment_id) {
        ResponseForm responseForm;

        RecruitmentDetailDTO detail = recruitmentService.getRecruitmentById(recruitment_id);

        if(detail != null) {
            responseForm= ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .count(1)
                    .msg("요청하신 공고 상세정보가 조회되었습니다.")
                    .result(Collections.singletonList(detail))
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 공고에 대한 환자 정보 불러오기 */
    @GetMapping("/recruitment/{recruitment_id}/patient")
    public ResponseEntity<ResponseForm> getRecruitmentPatientById(@PathVariable Long recruitment_id) {
        ResponseForm responseForm;

        RecruitmentPatientResponseDTO patient = recruitmentService.getRecruitmentPatientById(recruitment_id);

        if(patient != null) {
            responseForm= ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .count(1)
                    .msg("요청하신 공고의 환자정보가 조회되었습니다.")
                    .result(Collections.singletonList(patient))
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 공고에 대한 간병인 리스트 불러오기 */
    @GetMapping("/recruitment/{recruitment_id}/{request_by}")
    public ResponseEntity<ResponseForm> getApplicantListById(@PathVariable Long recruitment_id, @PathVariable String request_by) {
        ResponseForm responseForm;

        List<ApplicantsMateDTO> applicant = recruitmentService.getApplicantListById(recruitment_id, request_by);
        List<Object> result = new ArrayList<>(applicant);
        int listSize = result.size();

        if(listSize != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("해당 공고의 지원한 간병인 목록이 조회되었습니다.")
                    .count(listSize)
                    .result(result)
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 검색 조건에 따른 공고 검색 */
    @GetMapping("/search/recruitment")
    public ResponseEntity<ResponseForm> getSearchedRecruitment(SearchedRecruitmentRequestDTO requestDTO) {
        ResponseForm responseForm;

        List<SearchedRecruitmentResponseDTO> recruitmentList = recruitmentService.getSearchedRecruitment(requestDTO);
        List<Object> result = new ArrayList<>(recruitmentList);
        int listSize = result.size();

        if(listSize != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("검색 조건에 따른 공고가 조회되었습니다.")
                    .count(listSize)
                    .result(result)
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 공고 지원, 신청하기 */
    @PostMapping("apply")
    public ResponseEntity<ResponseForm> apply(@RequestBody ApplyInfoRequestDTO applyInfoRequestDTO) {
        ResponseForm responseForm;

        int result = recruitmentService.apply(applyInfoRequestDTO);

        if(result == 1) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("공고 지원이 완료되었습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("공고 지원에 실패했습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 로그인ID에 따른 패밀리의 대기중인 공고리스트 불러오기 */
    @GetMapping("/pendingRecruitment")
    public ResponseEntity<ResponseForm> getRecruitmentListById(HttpServletRequest request) {
        ResponseForm responseForm;

        String login_id = (String)request.getAttribute("id");

        List<PendingRecruitmentResponseDTO> pendingList = recruitmentService.getRecruitmentListById(login_id);
        List<Object> result = new ArrayList<>(pendingList);
        int listSize = result.size();

        if(listSize != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("예약이 확정되지 않은 공고 목록이 조회되었습니다.")
                    .count(listSize)
                    .result(result)
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* [간병인] 로그인ID에 따른 내가 지원한 공고 리스트 불러오기 */
    @GetMapping("/apply/recruitment-list")
    public ResponseEntity<ResponseForm> getAppliedRecruitmentListById(HttpServletRequest request) {
        ResponseForm responseForm;

        String login_id = (String)request.getAttribute("id");

        List<AppliedRecruitmentDTO> pendingList = recruitmentService.getAppliedRecruitmentListById(login_id);
        List<Object> result = new ArrayList<>(pendingList);
        int listSize = result.size();

        if(listSize != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("지원하신 공고 목록이 조회되었습니다.")
                    .count(listSize)
                    .result(result)
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* [간병인] 로그인ID에 따른 나에게 들어온 공고 리스트 불러오기 */
    @GetMapping("/offer/recruitment-list")
    public ResponseEntity<ResponseForm> getOfferedRecruitmentListById(HttpServletRequest request) {
        ResponseForm responseForm;

        String login_id = (String)request.getAttribute("id");

        List<AppliedRecruitmentDTO> pendingList = recruitmentService.getOfferedRecruitmentListById(login_id);
        List<Object> result = new ArrayList<>(pendingList);
        int listSize = result.size();

        if(listSize != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("요청 들어온 공고 목록이 조회되었습니다.")
                    .count(listSize)
                    .result(result)
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* [간병인] 지원 취소하기 */
    @DeleteMapping("/applicant/{recruitment_id}")
    public ResponseEntity<ResponseForm> deleteApplicant(HttpServletRequest request, @PathVariable Long recruitment_id) {
        ResponseForm responseForm;

        String login_id = (String)request.getAttribute("id");
        int result = recruitmentService.deleteApplicant(login_id, recruitment_id);

        if(result == 1) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("지원 취소가 완료되었습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("지원 취소에 실패했습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }
}
