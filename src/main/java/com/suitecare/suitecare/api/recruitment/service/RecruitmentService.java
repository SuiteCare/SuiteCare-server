package com.suitecare.suitecare.api.recruitment.service;

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
}
