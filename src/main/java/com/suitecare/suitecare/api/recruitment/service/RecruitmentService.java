package com.suitecare.suitecare.api.recruitment.service;

import com.suitecare.suitecare.api.recruitment.dto.RecruitmentRequestDTO;
import com.suitecare.suitecare.api.recruitment.mapper.RecruitmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruitmentService {

    @Autowired
    RecruitmentMapper recruitmentMapper;

    public Integer createRecruitment(String login_id, RecruitmentRequestDTO recruitmentRequestDTO) {
        return recruitmentMapper.createRecruitment(login_id, recruitmentRequestDTO);
    }
}
