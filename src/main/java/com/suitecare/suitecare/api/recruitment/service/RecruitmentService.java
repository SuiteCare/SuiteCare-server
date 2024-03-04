package com.suitecare.suitecare.api.recruitment.service;

import com.suitecare.suitecare.api.mate_resume.dto.SearchedMateResponseDTO;
import com.suitecare.suitecare.api.mate_resume.mapper.MateResumeMapper;
import com.suitecare.suitecare.api.recruitment.dto.*;
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

    public RecruitmentDetailDTO getRecruitmentById(Long recruitment_id) {
        return recruitmentMapper.getRecruitmentById(recruitment_id);
    }

    public RecruitmentPatientResponseDTO getRecruitmentPatientById(Long recruitment_id) {
        return recruitmentMapper.getRecruitmentPatientById(recruitment_id);
    }

    public List<SearchedMateResponseDTO> getApplicantListById(Long recruitment_id) {
        return recruitmentMapper.getApplicantListById(recruitment_id);
    }

    /* 간병 공고 검색 */
    public List<SearchedRecruitmentResponseDTO> getSearchedRecruitment(SearchedRecruitmentRequestDTO requestDTO) {
        List<Integer> excluded_days = new ArrayList<>();
        List<Integer> weekdays = new ArrayList<>(Arrays.asList(requestDTO.getWeekdays()));

        for(int day = 0; day < 7; day++) {
            if(!weekdays.contains(day)) excluded_days.add(day);
        }

        return recruitmentMapper.getSearchedRecruitment(requestDTO, excluded_days);
    }

    /* 간병인의 공고 지원하기 */
    public Integer apply(ApplyInfoRequestDTO applyRequestDTO) {

        /* 신청자 Mate인 경우, 이력서 여부 확인 */
        if(applyRequestDTO.getRequest_by().equals("M") && !isPresentResume(applyRequestDTO.getMate_id())) {
            return 0;
        }

        if(!isPresentApplicant(applyRequestDTO)) { // 해당 공고 지원 여부
            return recruitmentMapper.apply(applyRequestDTO);
        }

        return 2;

    }

    /* 간병인 이력서 유무 확인 */
    public boolean isPresentResume(String login_id) { // 간병인 이력서 여부
        return mateResumeMapper.isPresentResume(login_id) == 1;
    }

    /* 간병 지원 여부 */
    public boolean isPresentApplicant(ApplyInfoRequestDTO applyInfoRequestDTO) {
        return recruitmentMapper.isPresentApplicant(applyInfoRequestDTO) != 0;
    }

    /* 로그인 아이디에 따른 예약 확정되지 않은 공고 목록 */
    public List<PendingRecruitmentResponseDTO> getRecruitmentListById(String login_id) {
        return recruitmentMapper.getRecruitmentListById(login_id);
    }

    /* 로그인ID(M)에 따른 내가 지원한 공고 리스트 불러오기 */
    public List<AppliedRecruitmentDTO> getAppliedRecruitmentListById(String login_id) {
        return recruitmentMapper.getAppliedRecruitmentListById(login_id);
    }

    /* 로그인ID(M)에 따른 나에게 들어온 공고 리스트 불러오기 */
    public List<AppliedRecruitmentDTO> getOfferedRecruitmentListById(String login_id) {
        return recruitmentMapper.getOfferedRecruitmentListById(login_id);
    }

}
