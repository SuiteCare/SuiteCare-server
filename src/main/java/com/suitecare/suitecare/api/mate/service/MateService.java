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
    public ProfileResponseDTO findProfileById(int id) {
        ProfileResponseDTO result = new ProfileResponseDTO();

        List<MateDTO> mate = mateMapper.findMateById(id);
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
