package com.suitecare.suitecare.api.mate.mapper;

import com.suitecare.suitecare.api.mate.dto.MateDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MateMapper {
    MateDTO findResumeById(String login_id);
    Integer isPresentResume(Long id);
}
