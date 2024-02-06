package com.suitecare.suitecare.api.mate.mapper;

import com.suitecare.suitecare.api.mate.dto.CertificateDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CertificateMapper {
    List<CertificateDTO> findCertificateById(String login_id);
    void createCertificate(String login_id, List<CertificateDTO> certificate);
}
