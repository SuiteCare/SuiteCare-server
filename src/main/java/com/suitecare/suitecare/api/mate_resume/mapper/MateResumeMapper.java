package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.MateResumeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MateResumeMapper {
    MateResumeDTO findResumeById(String login_id);

    //List<SearchedMateResponseDTO> getSearchedMate(SearchedMateRequestDTO searchedMateRequestDTO);

    Integer isPresentResume(String login_id);

    Integer createMateResume(@Param("login_id") String login_id, @Param("mateResumeDTO") MateResumeDTO mateResumeDTO);

    void updateMateResume(@Param("login_id") String login_id, @Param("mateResumeDTO") MateResumeDTO mateResumeDTO);

    Integer deleteMateResume(String mate_resume_id);

}
