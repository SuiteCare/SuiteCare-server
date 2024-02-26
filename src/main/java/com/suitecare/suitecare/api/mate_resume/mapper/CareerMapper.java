package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.CareerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CareerMapper {

    List<CareerDTO> findCareerById(String id);

    // MateResume 생성 시 일괄 insert
    void createCareer(@Param("mate_resume_id") String mate_resume_id, @Param("careerList") List<CareerDTO> careerList);

    // 단일 건수 insert
    void insertCareer(@Param("mate_resume_id") String mate_resume_id, @Param("careerDTO") CareerDTO careerDTO);

    // 단일 건수 update
    void updateCareer(CareerDTO careerDTO);
}
