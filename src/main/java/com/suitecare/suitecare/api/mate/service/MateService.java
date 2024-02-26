package com.suitecare.suitecare.api.mate.service;

import com.suitecare.suitecare.api.mate.dto.*;
import com.suitecare.suitecare.api.mate.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Service
public class MateService {
    @Autowired
    MateMapper mateMapper;
    @Autowired
    CareerMapper careerMapper;
    @Autowired
    CertificateMapper certificateMapper;
    @Autowired
    LocationMapper locationMapper;
    @Autowired
    MainServiceMapper mainSeviceMapper;

    public ResumeResponseDTO findResumeById(String id) {
        ResumeResponseDTO result = new ResumeResponseDTO();

        MateDTO mate = mateMapper.findResumeById(id);
        List<CareerDTO> career = careerMapper.findCareerById(id);
        List<CertificateDTO> certificate = certificateMapper.findCertificateById(id);
        List<LocationDTO> location = locationMapper.findLocationById(id);
        List<MainServiceDTO> mainService = mainSeviceMapper.findMainServiceById(id);

        result.setMate(mate);
        result.setCareer(career);
        result.setCertificate(certificate);
        result.setLocation(location);
        result.setMainService(mainService);
        return result;
    }

    /* 간병인 이력서 등록 */
    @Transactional(rollbackFor = SQLException.class)
    public int createResume(String id, ResumeRequestDTO resumeRequestDTO) {
        try {
            int resume = mateMapper.createResume(id, resumeRequestDTO); // 기본 이력서 등록

            if(resumeRequestDTO.getCheckedLoc().length != 0) { // 활동 지역
                locationMapper.createLocation(id, resumeRequestDTO.getCheckedLoc());
            }

            if(resumeRequestDTO.getMainServiceData().length != 0) { // 대표서비스
                mainSeviceMapper.createMainService(id, resumeRequestDTO.getMainServiceData());
            }

            if(!resumeRequestDTO.getCareer().isEmpty()) { // 경력
                careerMapper.createCareer(id, resumeRequestDTO.getCareer());
            }

            if(!resumeRequestDTO.getCertificate().isEmpty()) { // 자격증
                certificateMapper.createCertificate(id, resumeRequestDTO.getCertificate());
            }

            return resume;
        } catch (Exception e) {
            log.error("Exception [Err_Location] : {}", e.getStackTrace()[0]);
            throw e;
        }
    }

    public void updateResume(String id, ResumeRequestDTO resumeRequestDTO) {
        mateMapper.updateResume(id, resumeRequestDTO);
    }

    public List<SearchedMateResponseDTO> getSearchedMate(SearchedMateRequestDTO searchedMateRequestDTO) {
        return mateMapper.getSearchedMate(searchedMateRequestDTO);
    }
}
