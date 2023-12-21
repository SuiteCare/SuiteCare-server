package com.suitecare.suitecare.api.mate.mapper;

import com.suitecare.suitecare.api.mate.dto.MateDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MateMapper {
    List<MateDTO> findMateById(int id);

}
