package com.suitecare.suitecare.api.mate_resume.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDTO {
    Long id;
    String name;
    String code;
    @JsonProperty("qualification_date")
    LocalDate qualificationDate;
    @JsonProperty("expired_date")
    LocalDate expiredDate;
}
