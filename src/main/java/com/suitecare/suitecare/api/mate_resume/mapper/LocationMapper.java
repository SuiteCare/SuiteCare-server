package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.LocationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LocationMapper {
    List<LocationDTO> findLocationById(String id);

    void createLocation(@Param("mate_resume_id") String mate_resume_id, @Param("locationList") List<LocationDTO> locationList);

    /* 단 건 insert (patch 로직에 사용) */
    void insertLocation(@Param("mate_resume_id") String mate_resume_id, @Param("locationDTO") LocationDTO locationDTO);

    void updateLocation(LocationDTO locationDTO);
}
