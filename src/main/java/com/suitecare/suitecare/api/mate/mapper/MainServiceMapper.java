package com.suitecare.suitecare.api.mate.mapper;

import com.suitecare.suitecare.api.mate.dto.MainServiceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainServiceMapper {
    List<MainServiceDTO> findMainServiceById(String id);
    void createMainService(Integer resume_id, String[] mainService);
}
