package com.suitecare.suitecare.api.recruitment.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class RecruitmentDetailDTO {
    private String location;
    private String road_address;
    private String address_detail;
    private int wage;
    private LocalTime start_time;
    private LocalTime end_time;
    private String weekday;
}
