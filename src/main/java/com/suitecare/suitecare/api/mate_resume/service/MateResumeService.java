package com.suitecare.suitecare.api.mate_resume.service;

import com.suitecare.suitecare.api.mate_resume.dto.*;
import com.suitecare.suitecare.api.mate_resume.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class MateResumeService {
    @Autowired
    MateResumeMapper mateResumeMapper;
    @Autowired
    CareerMapper careerMapper;
    @Autowired
    CertificateMapper certificateMapper;
    @Autowired
    LocationMapper locationMapper;
    @Autowired
    MainServiceMapper mainSeviceMapper;

    public ResumeDTO findMateResumeById(String id) {
        MateResumeDTO mateResume = mateResumeMapper.findResumeById(id);
        String mateResumeId = mateResume.getId();

        ResumeDTO resume = ResumeDTO.builder()
                .mateResume(mateResume)
                .careerList(careerMapper.findCareerById(mateResumeId))
                .certificateList(certificateMapper.findCertificateById(mateResumeId))
                .locationList(locationMapper.findLocationById(mateResumeId))
                .mainServiceList(mainSeviceMapper.findMainServiceById(mateResumeId))
                .build();

        System.out.println(resume);

        return resume;
    }

    /* 간병인 이력서 등록 */
    @Transactional
    public int createResume(String id, ResumeDTO resumeDTO) {

//        if(mateResumeMapper.findResumeById(id) != 0)

        // MateResume Insert
        mateResumeMapper.createMateResume(id, resumeDTO.getMateResume());

        // Career, Certificate, Location, MainService Insert
        careerMapper.createCareer(id, resumeDTO.getCareerList());
        certificateMapper.createCertificate(id, resumeDTO.getCertificateList());
        locationMapper.createLocation(id, resumeDTO.getLocationList());
        mainSeviceMapper.createMainService(id, resumeDTO.getMainServiceList());

        return 1;
    }
/*
    public void updateResume(String id, ResumeDTO resumeDTO) {
//        mateResumeMapper.updateMateResume(id, resumeRequestDTO);
    }

    public List<SearchedMateResponseDTO> getSearchedMate(SearchedMateRequestDTO searchedMateRequestDTO) {
        return mateResumeMapper.getSearchedMate(searchedMateRequestDTO);
    }
    */
}
