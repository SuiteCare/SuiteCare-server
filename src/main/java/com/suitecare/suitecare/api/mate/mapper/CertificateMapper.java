package com.suitecare.suitecare.api.mate.mapper;

import com.suitecare.suitecare.api.mate.dto.CertificateDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CertificateMapper {
    List<CertificateDTO> findCertificateById(String id);
    void createCertificate(Integer resume_id, List<CertificateDTO> certificate);
}
