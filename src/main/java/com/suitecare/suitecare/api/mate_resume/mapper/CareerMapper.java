package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.CareerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CareerMapper {
    List<CareerDTO> findCareerById(String id);
    void createCareer(String mateResumeId, List<CareerDTO> careerList);
}
