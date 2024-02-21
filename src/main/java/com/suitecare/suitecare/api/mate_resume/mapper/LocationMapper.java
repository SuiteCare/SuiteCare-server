package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.LocationDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationMapper {
    List<LocationDTO> findLocationById(String id);
    void createLocation(String mateResumeId, List<LocationDTO> locationList);
}
