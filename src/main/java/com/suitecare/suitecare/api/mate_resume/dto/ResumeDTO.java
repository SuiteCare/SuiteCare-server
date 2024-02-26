package com.suitecare.suitecare.api.mate_resume.dto;

import lombok.*;

import java.util.List;

@Getter
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
