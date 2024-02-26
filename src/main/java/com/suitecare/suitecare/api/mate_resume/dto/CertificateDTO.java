package com.suitecare.suitecare.api.mate_resume.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDTO {
    Long id;
    String name;
    String code;
    @JsonProperty("qualification_date")
    LocalDate qualification_date;
    @JsonProperty("expired_date")
    LocalDate expired_date;
}
