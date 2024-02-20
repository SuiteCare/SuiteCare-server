package com.suitecare.suitecare.api.mate.mapper;

import com.suitecare.suitecare.api.mate.dto.CareerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CareerMapper {
    List<CareerDTO> findCareerById(String id);
    void createCareer(Integer resume_id, List<CareerDTO> career);
}
