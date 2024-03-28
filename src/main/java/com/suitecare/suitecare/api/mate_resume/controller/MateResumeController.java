package com.suitecare.suitecare.api.mate_resume.controller;

import com.suitecare.suitecare.api.custom.format.ResponseForm;
import com.suitecare.suitecare.api.mate_resume.dto.ResumeDTO;
import com.suitecare.suitecare.api.mate_resume.dto.SearchedMateRequestDTO;
import com.suitecare.suitecare.api.mate_resume.dto.SearchedMateResponseDTO;
import com.suitecare.suitecare.api.mate_resume.service.MateResumeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
@Slf4j
public class MateResumeController {

    @Autowired
    MateResumeService mateResumeService;

    /* 간병인 이력서 조회 */
    @GetMapping("/mate/resume/{login_id}")
    public ResponseEntity<ResponseForm> getResume(@PathVariable String login_id) {
        ResponseForm responseForm;
        ResumeDTO resumeDTO = mateResumeService.findMateResumeById(login_id);

        if(resumeDTO != null) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("이력서를 성공적으로 조회했습니다.")
                    .count(0)
                    .result(List.of(resumeDTO))
                    .build();
        }else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("사용자의 이력서가 존재하지 않습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 간병인 검색결과 조회 */
    @GetMapping("/search/mate")
    public ResponseEntity<ResponseForm> getSearchedMate(HttpServletRequest request, @RequestBody SearchedMateRequestDTO searchedMateRequestDTO) {
        ResponseForm responseForm;
        String login_id = (String) request.getAttribute("id");
        List<SearchedMateResponseDTO> searchResultList = mateResumeService.getSearchedMate(login_id, searchedMateRequestDTO);
        if(searchResultList != null) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("이력서를 성공적으로 조회했습니다.")
                    .count(0)
                    .result(new ArrayList<>(searchResultList))
                    .build();
        }else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("이력서 검색에 실패했습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    @PostMapping("/mate/resume")
    public ResponseEntity<ResponseForm> uploadResume(HttpServletRequest request, @RequestPart(value = "file", required = false) MultipartFile profileImageFile,
                                @RequestPart("resumeData") ResumeDTO resumeDTO) throws IOException {

        String login_id = (String) request.getAttribute("id");
        mateResumeService.createResume(login_id, resumeDTO, profileImageFile);

        ResponseForm responseForm = ResponseForm.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .msg("이력서를 성공적으로 생성했습니다.")
                .count(0)
                .result(Collections.emptyList())
                .build();

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    @PatchMapping("/mate/resume")
    public ResponseEntity<ResponseForm> updateResume(HttpServletRequest request, @RequestPart(value = "file", required = false) MultipartFile profileImageFile,
                             @RequestPart("resumeData") ResumeDTO resumeDTO) throws IOException {
        String login_id = (String) request.getAttribute("id");
        mateResumeService.updateResume(login_id, resumeDTO, profileImageFile);

        ResponseForm responseForm = ResponseForm.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .msg("이력서를 성공적으로 수정했습니다.")
                .count(0)
                .result(Collections.emptyList())
                .build();

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 간병인 이력서 삭제 */
    @DeleteMapping("/mate/resume")
    public ResponseEntity<ResponseForm> deleteResume(HttpServletRequest request) {
        ResponseForm responseForm;
        String login_id = (String) request.getAttribute("id");

        Integer resultValue = mateResumeService.deleteResume(login_id);

        if(resultValue == 1) {
            responseForm = ResponseForm.builder()
                                    .code(HttpStatus.OK.value())
                                    .httpStatus(HttpStatus.OK)
                                    .msg("사용자의 이력서가 성공적으로 삭제되었습니다.")
                                    .count(0)
                                    .result(Collections.emptyList())
                                    .build();
        }else {
            responseForm = ResponseForm.builder()
                                    .code(HttpStatus.BAD_REQUEST.value())
                                    .httpStatus(HttpStatus.BAD_REQUEST)
                                    .msg("요청한 사용자의 이력서가 조회되지 않습니다.")
                                    .count(0)
                                    .result(Collections.emptyList())
                                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());

    }

}
