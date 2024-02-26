package com.suitecare.suitecare.api.recruitment.mapper;

import com.suitecare.suitecare.api.recruitment.dto.RecruitmentRequestDTO;
import com.suitecare.suitecare.api.recruitment.dto.SearchedRecruitmentRequestDTO;
import com.suitecare.suitecare.api.recruitment.dto.SearchedRecruitmentResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitmentMapper {
    Integer createRecruitment(String login_id, RecruitmentRequestDTO recruitmentRequestDTO);
    Integer createDayOfReservation(RecruitmentRequestDTO recruitmentRequestDTO);
    List<SearchedRecruitmentResponseDTO> getSearchedRecruitment(SearchedRecruitmentRequestDTO requestDTO, List<Integer> excluded_days);
    Integer isPresentApplicant(String login_id, Long recruitment_id);
    Integer applyRecruitment(String login_id, Long recruitment_id);
}
