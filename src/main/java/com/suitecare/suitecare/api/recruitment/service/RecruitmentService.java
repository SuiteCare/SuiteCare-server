package com.suitecare.suitecare.api.recruitment.service;

import com.suitecare.suitecare.api.recruitment.dto.RecruitmentRequestDTO;
import com.suitecare.suitecare.api.recruitment.mapper.RecruitmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
