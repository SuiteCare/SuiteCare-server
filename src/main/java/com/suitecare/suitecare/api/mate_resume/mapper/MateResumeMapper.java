package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.MateResumeDTO;
import com.suitecare.suitecare.api.mate_resume.dto.SearchedMateRequestDTO;
import com.suitecare.suitecare.api.mate_resume.dto.SearchedMateResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MateResumeMapper {
    MateResumeDTO findResumeById(String id);
    Integer isPresentResume(String id);
    Integer createMateResume(String id, MateResumeDTO mateResumeDTO);
    void updateMateResume(String id, MateResumeDTO mateResumeDTO);
    List<SearchedMateResponseDTO> getSearchedMate(SearchedMateRequestDTO searchedMateRequestDTO);
}
