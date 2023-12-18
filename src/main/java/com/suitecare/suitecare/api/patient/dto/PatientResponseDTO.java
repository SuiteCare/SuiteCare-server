package com.suitecare.suitecare.api.patient.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class PatientResponseDTO {
    private String diagnosis_name;
    private String gender;
    private Date birthday;
    private Date start_date;
    private Date end_date;
    private String[] day_of_week;
    private int wage;
}
