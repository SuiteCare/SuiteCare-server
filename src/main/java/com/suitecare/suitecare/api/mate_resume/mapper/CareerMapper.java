package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.CareerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CareerMapper {
    List<CareerDTO> findCareerById(String id);
    void createCareer(@Param("mateResumeId") String mateResumeId, @Param("careerList")List<CareerDTO> careerList);
}
