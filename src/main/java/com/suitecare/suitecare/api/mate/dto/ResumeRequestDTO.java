package com.suitecare.suitecare.api.mate.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResumeRequestDTO {
    private String filename;
    private String contactTimeStart;
    private String contactTimeEnd;
    private String introduction;
    private String[] mainServiceData;
    private String[] checkedLoc;
    private List<CareerDTO> career;
    private List<CertificateDTO> certificate;
    private String wage;
}
