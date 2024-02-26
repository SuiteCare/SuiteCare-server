package com.suitecare.suitecare.api.mate_resume.controller;

import com.suitecare.suitecare.api.mate_resume.dto.ResumeDTO;
import com.suitecare.suitecare.api.mate_resume.service.MateResumeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
@Slf4j
public class MateResumeController {

    @Autowired
    MateResumeService mateResumeService;

    /* 간병인 이력서 조회 */
    @GetMapping("/mate/resume")
    public ResumeDTO getResume(HttpServletRequest request) {
        String id = (String) request.getAttribute("id");
        return mateResumeService.findMateResumeById(id);
    }

    /* 간병인 이력서 등록 */
    @PostMapping("/mate/resume")
    public int createResume(HttpServletRequest request, @RequestBody ResumeDTO resumeDTO) {
        String id = (String) request.getAttribute("id");
        return mateResumeService.createResume(id, resumeDTO);
    }

    @PatchMapping("/mate/resume")
    public void updateResume(HttpServletRequest request, @RequestBody ResumeDTO resumeDTO) {
        String login_id = (String) request.getAttribute("id");
        mateResumeService.updateResume(login_id, resumeDTO);
    }

    /*
    @GetMapping("/search/mate")
    public List<SearchedMateResponseDTO> getSearchedMate(SearchedMateRequestDTO searchedMateRequestDTO) {
        return mateResumeService.getSearchedMate(searchedMateRequestDTO);
    }
    */
}
