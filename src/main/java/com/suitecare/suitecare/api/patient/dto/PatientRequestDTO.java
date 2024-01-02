package com.suitecare.suitecare.api.patient.dto;

import lombok.Data;

@Data
public class PatientRequestDTO {
    private String id;
    private String family_id;
    private String name;
    private String gender;
    private String birthday;
    private String height;
    private String weight;
    private String diagnosis_name;

}