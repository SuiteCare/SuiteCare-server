package com.suitecare.suitecare.api.reservation.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicantInfoResponseDTO {
    private String name;
    private LocalDate birthday;
    private String profile_picture_filename;
    private String introduction;
    private String contact_time_start;
    private String contact_time_end;
    private String desired_wage;
    private String mainservice;
    private String location;
}
