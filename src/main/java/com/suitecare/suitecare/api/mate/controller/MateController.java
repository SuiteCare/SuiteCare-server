package com.suitecare.suitecare.api.mate.controller;

import com.suitecare.suitecare.api.mate.dto.*;
import com.suitecare.suitecare.api.mate.service.MateService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
@Slf4j
public class MateController {

    @Autowired
    MateService mateService;

    @GetMapping("/mate/resume")
    public ResumeResponseDTO resume(HttpServletRequest request) {
        String id = (String) request.getAttribute("id");
        return mateService.findResumeById(id);
    }

    /* 간병인 이력서 등록 */
    @PostMapping("/mate/resume")
    public int createResume(HttpServletRequest request, @RequestBody ResumeRequestDTO resumeRequestDTO) {
        System.err.println(resumeRequestDTO);
        String id = (String) request.getAttribute("id");
        try {
            return mateService.createResume(id, resumeRequestDTO);
        } catch (Exception e) {
            log.error("Exception [Err_Msg]: {}", e.getMessage());
            return 0;
        }
    }

    @PatchMapping("/mate/resume")
    public void updateResume(HttpServletRequest request, @RequestBody ResumeRequestDTO resumeRequestDTO) {
        String id = (String) request.getAttribute("id");
        mateService.updateResume(id, resumeRequestDTO);
    }

    @GetMapping("/search/mate")
    public List<SearchedMateResponseDTO> getSearchedMate(SearchedMateRequestDTO searchedMateRequestDTO) {
        return mateService.getSearchedMate(searchedMateRequestDTO);
    }
}
