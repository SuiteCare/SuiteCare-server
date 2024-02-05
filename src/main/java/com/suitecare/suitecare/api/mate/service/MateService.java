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
/*
    public int create(CreateMemberRequestDTO createMemberRequestDTO) {
    }
*/
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
}
