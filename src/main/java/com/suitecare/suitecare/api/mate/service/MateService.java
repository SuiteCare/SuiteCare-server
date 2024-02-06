package com.suitecare.suitecare.api.mate.service;

import com.suitecare.suitecare.api.mate.dto.*;
import com.suitecare.suitecare.api.mate.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ResumeResponseDTO findResumeById(String login_id) {
        ResumeResponseDTO result = new ResumeResponseDTO();

        MateDTO mate = mateMapper.findResumeById(login_id);
        List<CareerDTO> career = careerMapper.findCareerById(login_id);
        List<CertificateDTO> certificate = certificateMapper.findCertificateById(login_id);
        List<LocationDTO> location = locationMapper.findLocationById(login_id);
        List<MainServiceDTO> mainService = mainSeviceMapper.findMainServiceById(login_id);

        result.setMate(mate);
        result.setCareer(career);
        result.setCertificate(certificate);
        result.setLocation(location);
        result.setMainService(mainService);
        return result;
    }

    /* 간병인 이력서 등록 */
    public int createResume(String login_id, ResumeRequestDTO resumeRequestDTO) {
        int resume = mateMapper.createResume(login_id, resumeRequestDTO); // 기본 이력서 등록

        if(resumeRequestDTO.getCheckedLoc().length != 0) { // 활동 지역
            locationMapper.createLocation(login_id, resumeRequestDTO.getCheckedLoc());
        }

        if(resumeRequestDTO.getMainServiceData().length != 0) { // 대표서비스
            mainSeviceMapper.createMainService(login_id, resumeRequestDTO.getMainServiceData());
        }

        if(!resumeRequestDTO.getCareer().isEmpty()) { // 경력
            careerMapper.createCareer(login_id, resumeRequestDTO.getCareer());
        }

        if(!resumeRequestDTO.getCertificate().isEmpty()) { // 자격증
            certificateMapper.createCertificate(login_id, resumeRequestDTO.getCertificate());
        }

        return resume;
    }
}
