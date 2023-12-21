package com.suitecare.suitecare.api.mate.dto;

import lombok.Data;
import java.sql.Date;

@Data
public class CertificateDTO {
    Long id;
    String certificate_name;
    String certificate_code;
    Date qualification_date;
    Date expired_date;
}
