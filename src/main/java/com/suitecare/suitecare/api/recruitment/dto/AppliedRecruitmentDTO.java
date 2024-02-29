package com.suitecare.suitecare.api.recruitment.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppliedRecruitmentDTO {
    /* 공고 정보 */
    private Long recruitment_id;
    private String member_id;
    private String patient_gender;
    private LocalDate patient_birthday;
    private String patient_diagnosis_name;
    private String location;
    private String road_address;
    private Integer wage;
    private LocalDate start_date;
    private LocalDate end_date;
    private LocalTime start_time;
    private LocalTime end_time;
    private String day;
    private String tel;
    private Timestamp expire_at; // 공고 만료 날짜

    /* 지원에 대한 정보 */
    private String status; // 지원에 대한 상태 (P, C, R)
    private Timestamp create_at; // 지원 날짜
}
