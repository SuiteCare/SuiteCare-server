package com.suitecare.suitecare.api.mate_resume.dto;

import com.suitecare.suitecare.api.custom.ifc.HasIdNDeletable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDTO implements HasIdNDeletable {
    private Long id;
    private String name;
    private String code;
    private LocalDate qualification_date;
    private LocalDate expired_date;
    private Boolean isDeleted;
}
