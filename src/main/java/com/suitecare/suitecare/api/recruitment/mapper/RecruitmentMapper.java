package com.suitecare.suitecare.api.recruitment.mapper;

import com.suitecare.suitecare.api.recruitment.dto.RecruitmentRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecruitmentMapper {
    Integer createRecruitment(String login_id, RecruitmentRequestDTO recruitmentRequestDTO);
    Integer createDayOfReservation(RecruitmentRequestDTO recruitmentRequestDTO);
}
