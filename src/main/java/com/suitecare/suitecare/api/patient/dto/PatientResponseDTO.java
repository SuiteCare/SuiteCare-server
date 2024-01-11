package com.suitecare.suitecare.api.patient.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class PatientResponseDTO {
    private String name;
    private String diagnosis_name;
    private String gender;
    private Date birthday;
    private String height;
    private String weight;
}
