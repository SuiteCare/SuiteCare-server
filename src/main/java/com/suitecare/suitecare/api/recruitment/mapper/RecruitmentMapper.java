package com.suitecare.suitecare.api.recruitment.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.SearchedMateResponseDTO;
import com.suitecare.suitecare.api.recruitment.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecruitmentMapper {
    Integer createRecruitment(@Param("login_id") String login_id, @Param("recruitmentRequestDTO") RecruitmentRequestDTO recruitmentRequestDTO);
    Integer createDayOfReservation(RecruitmentRequestDTO recruitmentRequestDTO);
    RecruitmentDetailDTO getRecruitmentById(Long recruitment_id);
    RecruitmentPatientResponseDTO getRecruitmentPatientById(Long recruitment_id);
    List<SearchedMateResponseDTO> getApplicantListById(Long recruitment_id);
    List<SearchedRecruitmentResponseDTO> getSearchedRecruitment(@Param("requestDTO") SearchedRecruitmentRequestDTO requestDTO, @Param("excluded_days")List<Integer> excluded_days);
    Integer isPresentApplicant(@Param("mate_id") String mate_id, @Param("recruitment_id") Long recruitment_id, @Param("role") String role);
    Integer applyToRecruitment(@Param("login_id") String login_id, @Param("recruitment_id") Long recruitment_id);
    Integer applyToMate(ApplyToMateRequestDTO applyToMateRequestDTO);
    List<PendingRecruitmentResponseDTO> getRecruitmentListById(String login_id);
    List<AppliedRecruitmentDTO> getAppliedRecruitmentListById(String login_id);
}
