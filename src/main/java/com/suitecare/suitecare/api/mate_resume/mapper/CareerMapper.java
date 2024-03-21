package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.CareerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CareerMapper {

    List<CareerDTO> findCareerById(String id);

    void createCareer(@Param("mate_resume_id") String mate_resume_id, @Param("careerList") List<CareerDTO> careerList);

    /* 단 건 insert (patch 로직에 사용) */
    void insertCareer(@Param("mate_resume_id") String mate_resume_id, @Param("careerDTO") CareerDTO careerDTO);

    void updateCareer(CareerDTO careerDTO);

    void deleteCareer(Long id);
}
