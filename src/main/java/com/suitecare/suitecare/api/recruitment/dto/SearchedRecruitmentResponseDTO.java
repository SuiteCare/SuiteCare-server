package com.suitecare.suitecare.api.recruitment.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class SearchedRecruitmentResponseDTO {
    private Integer id;
    private String member_id;
    private String gender;
    private LocalDate birthday;
    private String diagnosis_name;
    private String location;
    private String road_address;
    private Integer wage;
    private LocalDate start_date;
    private LocalDate end_date;
    private LocalTime start_time;
    private LocalTime end_time;
    private String day;
    private String tel;
    private Timestamp expire_at;
}
