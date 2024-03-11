package com.suitecare.suitecare.api.mate_resume.service;

import com.suitecare.suitecare.api.custom.ifc.DTO;
import com.suitecare.suitecare.api.mate_resume.dto.*;
import com.suitecare.suitecare.api.mate_resume.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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

    public List<SearchedMateResponseDTO> getSearchedMate(SearchedMateRequestDTO searchedMateRequestDTO) {
        return mateResumeMapper.getSearchedMate(searchedMateRequestDTO);
    }

    /* 간병인 이력서 등록 */
    @Transactional
    public int createResume(String login_id, ResumeDTO resume_dto) {

        // 이력서 Insert
        mateResumeMapper.createMateResume(login_id, resume_dto.getMateResume());

        // 경력 Insert
        if(resume_dto.getCareerList() != null) {
            careerMapper.createCareer(login_id, resume_dto.getCareerList());
        }
        // 자격증 Insert
        if(resume_dto.getCertificateList() != null) {
            certificateMapper.createCertificate(login_id, resume_dto.getCertificateList());
        }
        // 지역 Insert
        locationMapper.createLocation(login_id, resume_dto.getLocationList());
        // 대표서비스 Insert
        mainSeviceMapper.createMainService(login_id, resume_dto.getMainServiceList());

        return 1;

    }

    /* 이력서 업데이트 */
    @Transactional
    public void updateResume(String login_id, ResumeDTO resumeDTO) {

        /* 이력서 기본 정보 업데이트 */
        if (resumeDTO.getMateResume() != null) mateResumeMapper.updateMateResume(login_id, resumeDTO.getMateResume());

        /* 이력서 상세 정보 업데이트 */
        updateDtoElement(login_id, resumeDTO.getCareerList(), careerMapper::insertCareer, careerMapper::updateCareer);
        updateDtoElement(login_id, resumeDTO.getCertificateList(), certificateMapper::insertCertificate, certificateMapper::updateCertificate);

        if(resumeDTO.getLocationList() != null) {
            locationMapper.deleteLocation(login_id);
            locationMapper.createLocation(login_id, resumeDTO.getLocationList());
        }

        if(resumeDTO.getMainServiceList() != null) {
            mainSeviceMapper.deleteMainService(login_id);
            mainSeviceMapper.createMainService(login_id, resumeDTO.getMainServiceList());
        }
    }

    /* DTO 요소 업데이트를 위한 메소드 */
    public static <T extends DTO> void updateDtoElement(String login_id, List<T> elements, BiConsumer<String, T> insertMethod, Consumer<T> updateMethod) {

        if (elements == null) return;

        elements.forEach(element -> {
            if (element.getId() == null) {
                insertMethod.accept(login_id, element);
            } else {
                updateMethod.accept(element);
            }
        });

    }

    public Integer deleteResume(String login_id) {
        return mateResumeMapper.deleteMateResume(login_id);
    }
}
