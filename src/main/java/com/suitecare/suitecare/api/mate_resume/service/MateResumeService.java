package com.suitecare.suitecare.api.mate_resume.service;

import com.suitecare.suitecare.api.mate_resume.dto.*;
import com.suitecare.suitecare.api.mate_resume.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /* 간병인 이력서 등록 */
    @Transactional
    public int createResume(String id, ResumeDTO resume_dto) {

        // 이력서 Insert
        mateResumeMapper.createMateResume(id, resume_dto.getMateResume());

        // 경력 Insert
        if(resume_dto.getCareerList() != null) {
            careerMapper.createCareer(id, resume_dto.getCareerList());
        }
        // 자격증 Insert
        if(resume_dto.getCertificateList() != null) {
            certificateMapper.createCertificate(id, resume_dto.getCertificateList());
        }
        // 지역 Insert
        locationMapper.createLocation(id, resume_dto.getLocationList());
        // 대표서비스 Insert
        mainSeviceMapper.createMainService(id, resume_dto.getMainServiceList());

        return 1;

    }

    /* 이력서 조회 */
    public ResumeDTO findMateResumeById(String login_id) {

        MateResumeDTO mateResumeDTO = mateResumeMapper.findResumeById(login_id);
        String mate_resume_id = mateResumeDTO.getId();

        return ResumeDTO.builder()
                .mateResume(mateResumeDTO)
                .careerList(careerMapper.findCareerById(mate_resume_id))
                .certificateList(certificateMapper.findCertificateById(mate_resume_id))
                .locationList(locationMapper.findLocationById(mate_resume_id))
                .mainServiceList(mainSeviceMapper.findMainServiceById(mate_resume_id))
                .build();

    }

    /* 이력서 업데이트 */
    @Transactional
    public void updateResume(String login_id, ResumeDTO resumeDTO) {

        /* 이력서 기본 정보 업데이트 */
        MateResumeDTO mateResumeDTO = resumeDTO.getMateResume();
        mateResumeMapper.updateMateResume(login_id, mateResumeDTO);

        /* 경력 업데이트 */
        for(CareerDTO careerDTO : resumeDTO.getCareerList()) {
            // id 가 null 인 경우 신규
            if(careerDTO.getId() == null) {
                careerMapper.insertCareer(login_id, careerDTO);
            }else {
                careerMapper.updateCareer(careerDTO);
            }
        }

        /* 자격증 업데이트 */
        for(CertificateDTO certificateDTO : resumeDTO.getCertificateList()) {
            // id 가 null 인 경우 신규
            if(certificateDTO.getId() == null) {
                certificateMapper.insertCertificate(login_id, certificateDTO);
            }else {
                certificateMapper.updateCertificate(certificateDTO);
            }
        }

        /* 지역 업데이트 */
        for(LocationDTO locationDTO : resumeDTO.getLocationList()) {
            // id 가 null 인 경우 신규
            if(locationDTO.getId() == null) {
                locationMapper.insertLocation(login_id, locationDTO);
            }else {
                locationMapper.updateLocation(locationDTO);
            }
        }

        /* 대표 서비스 업데이트 */
        for(MainServiceDTO mainServiceDTO : resumeDTO.getMainServiceList()) {
            // id 가 null 인 경우 신규
            if(mainServiceDTO.getId() == null) {
                mainSeviceMapper.insertMainService(login_id, mainServiceDTO);
            }else {
                mainSeviceMapper.updateMainService(mainServiceDTO);
            }
        }
    }
    /*
    public List<SearchedMateResponseDTO> getSearchedMate(SearchedMateRequestDTO searchedMateRequestDTO) {
        return mateResumeMapper.getSearchedMate(searchedMateRequestDTO);
    }
    */
}
