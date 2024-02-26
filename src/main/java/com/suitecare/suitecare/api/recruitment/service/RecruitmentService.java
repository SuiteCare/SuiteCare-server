package com.suitecare.suitecare.api.recruitment.service;

import com.suitecare.suitecare.api.mate.mapper.MateMapper;
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
    MateMapper mateMapper;

    @Transactional
    public Integer createRecruitment(String login_id, RecruitmentRequestDTO recruitmentRequestDTO) {
        if(recruitmentMapper.createRecruitment(login_id, recruitmentRequestDTO) == 1) {
            return recruitmentMapper.createDayOfReservation(recruitmentRequestDTO);
        }
        return 0;
    }

    public List<SearchedRecruitmentResponseDTO> getSearchedRecruitment(SearchedRecruitmentRequestDTO requestDTO) {
        List<Integer> excluded_days = new ArrayList<>();
        List<Integer> weekdays = new ArrayList<>(Arrays.asList(requestDTO.getWeekdays()));

        for(int day = 0; day < 7; day++) {
            if(!weekdays.contains(day)) excluded_days.add(day);
        }

        System.err.println("size : " + excluded_days.size());

        return recruitmentMapper.getSearchedRecruitment(requestDTO, excluded_days);
    }

    public Integer applyRecruitment(String login_id, Long recruitment_id) {
        if(!isPresentResume(login_id)) {
            return 0;
        }

        if(!isPresentApplicant(login_id, recruitment_id)) {
            return recruitmentMapper.applyRecruitment(login_id, recruitment_id);
        }

        return 2;
    }

    public boolean isPresentResume(String login_id) { // 간병인 이력서 여부
        return mateMapper.isPresentResume(login_id) != null;
    }

    public boolean isPresentApplicant(String login_id, Long recruitment_id) { // 지원 여부
        return recruitmentMapper.isPresentApplicant(login_id, recruitment_id) != 0;
    }
}
