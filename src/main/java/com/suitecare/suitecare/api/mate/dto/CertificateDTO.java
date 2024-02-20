package com.suitecare.suitecare.api.mate.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CertificateDTO {
    Long id;
    String name;
    String code;
    LocalDate qualification_date;
    LocalDate expired_date;
}
