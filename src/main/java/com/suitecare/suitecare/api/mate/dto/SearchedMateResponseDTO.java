package com.suitecare.suitecare.api.mate.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchedMateResponseDTO {
    private String name;
    private String profile_picture_filename;
    private String introduction;
    private String contact_time_start;
    private String contact_time_end;
    private String desired_wage;
    private String gender;
    private LocalDate birthday;
    private String location;
    private String mainservice;
}

