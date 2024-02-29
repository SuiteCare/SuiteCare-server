package com.suitecare.suitecare.api.mate_resume.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.suitecare.suitecare.api.custom.ifc.DTO;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDTO implements DTO {
    Long id;
    String name;
    String code;
    @JsonProperty("qualification_date")
    LocalDate qualification_date;
    @JsonProperty("expired_date")
    LocalDate expired_date;
}
