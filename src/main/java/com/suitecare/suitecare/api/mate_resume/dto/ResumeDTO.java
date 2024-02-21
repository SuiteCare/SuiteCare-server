package com.suitecare.suitecare.api.mate_resume.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDTO {
    private MateResumeDTO mateResume;
    private List<CareerDTO> careerList;
    private List<CertificateDTO> certificateList;
    private List<LocationDTO> locationList;
    private List<MainServiceDTO> mainServiceList;
}
