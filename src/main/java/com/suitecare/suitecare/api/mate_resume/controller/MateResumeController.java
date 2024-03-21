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
    public ResumeDTO getResume(@PathVariable String login_id) {
        return mateResumeService.findMateResumeById(login_id);
    }

    /* 간병인 검색결과 조회 */
    @GetMapping("/search/mate")
    public List<SearchedMateResponseDTO> getSearchedMate(HttpServletRequest request, SearchedMateRequestDTO searchedMateRequestDTO) {
        String login_id = (String) request.getAttribute("id");
        return mateResumeService.getSearchedMate(login_id, searchedMateRequestDTO);
    }

    @PostMapping("/mate/resume")
    public Integer uploadResume(HttpServletRequest request, @RequestPart("file") MultipartFile file,
                                          @RequestPart("resumeData") ResumeDTO resumeData) throws IOException {
        String login_id = (String) request.getAttribute("id");
        return mateResumeService.createResume(login_id, resumeData, file);
    }

    @PatchMapping("/mate/resume")
    public void updateResume(HttpServletRequest request, @RequestBody ResumeDTO resumeDTO) {
        String login_id = (String) request.getAttribute("id");
        mateResumeService.updateResume(login_id, resumeDTO);
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
