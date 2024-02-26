package com.suitecare.suitecare.api.recruitment.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PendingRecruitmentResponseDTO {
    private Long id;
    private String patient_name;
    private String patient_diagnosis_name;
    private LocalDate start_date;
    private LocalDate end_date;
}
