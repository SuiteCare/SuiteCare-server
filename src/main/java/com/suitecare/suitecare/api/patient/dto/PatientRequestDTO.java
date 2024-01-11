package com.suitecare.suitecare.api.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequestDTO {
    private Long id;
    private Long family_id;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String height;
    private String weight;
    private String diagnosis_name;
    private String consciousness_state;
    private String paralysis_state;
    private String behavioral_state;
    private String meal_care_state;
    private String toilet_care_state;
    private String is_bedsore;
    private String need_suction;
    private String need_outpatient;
    private String need_night_care;
    private String notice;
}