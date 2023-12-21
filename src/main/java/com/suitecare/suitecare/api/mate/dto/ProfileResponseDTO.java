package com.suitecare.suitecare.api.mate.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProfileResponseDTO {
    private List<MateDTO> mate;
    private List<CareerDTO> career;
    private List<CertificateDTO> certificate;
    private List<LocationDTO> location;
    private List<MainServiceDTO> mainService;
}
