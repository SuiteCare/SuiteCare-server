package com.suitecare.suitecare.api.patient.dto;

import lombok.Data;

@Data
public class PatientDetailRequestDTO {
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