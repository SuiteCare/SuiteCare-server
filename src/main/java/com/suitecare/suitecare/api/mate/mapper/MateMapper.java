package com.suitecare.suitecare.api.mate.mapper;

import com.suitecare.suitecare.api.mate.dto.MateDTO;
import com.suitecare.suitecare.api.mate.dto.ResumeRequestDTO;
import com.suitecare.suitecare.api.mate.dto.SearchedMateRequestDTO;
import com.suitecare.suitecare.api.mate.dto.SearchedMateResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MateMapper {
    MateDTO findResumeById(String id);
    Integer isPresentResume(String id);
    Integer createResume(String id, ResumeRequestDTO resumeRequestDTO);
    void updateResume(String id, ResumeRequestDTO resumeRequestDTO);
    List<SearchedMateResponseDTO> getSearchedMate(SearchedMateRequestDTO searchedMateRequestDTO);
}
