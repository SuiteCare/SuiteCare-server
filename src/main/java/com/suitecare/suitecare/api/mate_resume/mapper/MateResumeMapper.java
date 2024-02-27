package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.MateResumeDTO;
import com.suitecare.suitecare.api.mate_resume.dto.SearchedMateRequestDTO;
import com.suitecare.suitecare.api.mate_resume.dto.SearchedMateResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MateResumeMapper {
    MateResumeDTO findResumeById(String id);
    Integer isPresentResume(String login_id);
    Integer createMateResume(@Param("id") String id, @Param("mateResumeDTO") MateResumeDTO mateResumeDTO);
    void updateMateResume(@Param("login_id") String login_id, @Param("mateResumeDTO") MateResumeDTO mateResumeDTO);
    List<SearchedMateResponseDTO> getSearchedMate(SearchedMateRequestDTO searchedMateRequestDTO);
}
