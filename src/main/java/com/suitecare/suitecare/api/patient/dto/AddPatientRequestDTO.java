package com.suitecare.suitecare.api.patient.dto;

import lombok.Data;

@Data
public class AddPatientRequestDTO {
    private String family_id;
    private String name;
    private String gender;
    private String birthday;
    private String height;
    private String weight;
    private String diagnosis_name;
    private String consciousness_state;
    private String paralysis_state;
    private String behavioral_state;
    private String need_meal_care;
    private String need_toilet_care;
    private String is_bedsore;
    private String need_suction;
    private String need_outpatient;
    private String need_night_care;
    private String notice;
}
