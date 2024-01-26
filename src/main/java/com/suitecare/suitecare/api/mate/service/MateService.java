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
    public ResumeResponseDTO findResumeById(Long id) {
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
        result.setLocation(location);
        result.setMainService(mainService);
        return result;
    }
}
