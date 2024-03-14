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
    private Long id;
    private String name;
    private String code;
    @JsonProperty("qualification_date")
    private LocalDate qualification_date;
    @JsonProperty("expired_date")
    private LocalDate expired_date;
    private Boolean deleted;
}
