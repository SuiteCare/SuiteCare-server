package com.suitecare.suitecare.api.recruitment.service;

import com.suitecare.suitecare.api.mate_resume.mapper.MateResumeMapper;
import com.suitecare.suitecare.api.recruitment.dto.PendingRecruitmentResponseDTO;
import com.suitecare.suitecare.api.recruitment.dto.RecruitmentRequestDTO;
import com.suitecare.suitecare.api.recruitment.dto.SearchedRecruitmentRequestDTO;
import com.suitecare.suitecare.api.recruitment.dto.SearchedRecruitmentResponseDTO;
import com.suitecare.suitecare.api.recruitment.mapper.RecruitmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RecruitmentService {

    @Autowired
    RecruitmentMapper recruitmentMapper;
    @Autowired
    MateResumeMapper mateResumeMapper;

    /* 간병 공고 등록 */
    @Transactional
    public Integer createRecruitment(String login_id, RecruitmentRequestDTO recruitmentRequestDTO) {
        if(recruitmentMapper.createRecruitment(login_id, recruitmentRequestDTO) == 1) {
            return recruitmentMapper.createDayOfReservation(recruitmentRequestDTO);
        }
        return 0;
    }

    /* 간병 공고 검색 */
    public List<SearchedRecruitmentResponseDTO> getSearchedRecruitment(SearchedRecruitmentRequestDTO requestDTO) {
        List<Integer> excluded_days = new ArrayList<>();
        List<Integer> weekdays = new ArrayList<>(Arrays.asList(requestDTO.getWeekdays()));

        for(int day = 0; day < 7; day++) {
            if(!weekdays.contains(day)) excluded_days.add(day);
        }

        System.err.println("size : " + excluded_days.size());

        return recruitmentMapper.getSearchedRecruitment(requestDTO, excluded_days);
    }

    /* 간병인의 공고 지원하기 */
    public Integer applyRecruitment(String login_id, Long recruitment_id) {
        if(!isPresentResume(login_id)) {
            return 0;
        }

        if(!isPresentApplicant(login_id, recruitment_id)) {
            return recruitmentMapper.applyRecruitment(login_id, recruitment_id);
        }

        return 2;
    }

    /* 간병인 이력서 유무 확인 */
    public boolean isPresentResume(String login_id) { // 간병인 이력서 여부
        return mateResumeMapper.isPresentResume(login_id) != 1;
    }

    /* 간병 지원 여부 */
    public boolean isPresentApplicant(String login_id, Long recruitment_id) { // 지원 여부
        return recruitmentMapper.isPresentApplicant(login_id, recruitment_id) != 0;
    }

    /* 로그인 아이디에 따른 예약 확정되지 않은 공고 목록 */
    public List<PendingRecruitmentResponseDTO> getRecruitmentListById(String login_id) {
        return recruitmentMapper.getRecruitmentListById(login_id);
    }
}
