package com.suitecare.suitecare.api.recruitment.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RecruitmentPatientResponseDTO {
    private String patient_gender;
    private LocalDate patient_birthday;
    private String patient_diagnosis_name;
    private String patient_height;
    private String patient_weight;
    private String patient_consciousness_state;
    private String patient_meal_care_state;
    private String patient_toilet_care_state;
    private String patient_paralysis_state;
    private String patient_behavioral_state;
    private String patient_is_bedsore;
    private String patient_need_suction;
    private String patient_need_outpatient;
    private String patient_need_night_care;
    private String patient_notice;
}
