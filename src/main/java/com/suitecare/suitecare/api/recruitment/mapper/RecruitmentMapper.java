package com.suitecare.suitecare.api.recruitment.mapper;

import com.suitecare.suitecare.api.recruitment.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitmentMapper {
    Integer createRecruitment(String login_id, RecruitmentRequestDTO recruitmentRequestDTO);
    Integer createDayOfReservation(RecruitmentRequestDTO recruitmentRequestDTO);
    RecruitmentDetailDTO getRecruitmentById(Long id);
    RecruitmentPatientResponseDTO getRecruitmentPatientById(Long id);
    List<SearchedRecruitmentResponseDTO> getSearchedRecruitment(SearchedRecruitmentRequestDTO requestDTO, List<Integer> excluded_days);
    Integer isPresentApplicant(String login_id, Long recruitment_id);
    Integer applyRecruitment(String login_id, Long recruitment_id);
    List<PendingRecruitmentResponseDTO> getRecruitmentListById(String login_id);
}
