package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.MainServiceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainServiceMapper {
    List<MainServiceDTO> findMainServiceById(String id);
    void createMainService(@Param("mate_resume_id") String mate_resume_id, @Param("mainServiceList") List<MainServiceDTO> mainServiceList);

    /* 단건 Insert */
    void insertMainService(String login_id, MainServiceDTO mainServiceDTO);

    /* 단건 Update */
    void updateMainService(MainServiceDTO mainServiceDTO);
}
