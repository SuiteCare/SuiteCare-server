package com.suitecare.suitecare.api.mate_resume.mapper;

import com.suitecare.suitecare.api.mate_resume.dto.CertificateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CertificateMapper {
    List<CertificateDTO> findCertificateById(String id);
    void createCertificate(@Param("mate_resume_id") String mate_resume_id, @Param("certificateList") List<CertificateDTO> certificateList);

    /* 단건 Insert */
    void insertCertificate(String login_id, CertificateDTO certificateDTO);

    /* 단건 Update */
    void updateCertificate(CertificateDTO certificateDTO);
}
