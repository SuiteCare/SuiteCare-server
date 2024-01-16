package com.suitecare.suitecare.api.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDetailResponseDTO {
    // 의식 상태
    private String consciousness_state;
    // 식사 보조
    private String meal_care_state;
    // 용변 보조
    private String toilet_care_state;
    // 마비 상태
    private String paralysis_state;
    // 거동 상태
    private String behavioral_state;
    // 욕창 여부
    private String is_bedsore;
    // 석션 여부
    private String need_suction;
    // 주기 외래 진료 여부
    private String need_outpatient;
    // 야간 간병 여부
    private String need_night_care;
    // 비고
    private String notice;
}