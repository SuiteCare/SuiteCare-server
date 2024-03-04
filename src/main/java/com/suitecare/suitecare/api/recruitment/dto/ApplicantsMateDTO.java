package com.suitecare.suitecare.api.recruitment.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicantsMateDTO {
    private String mate_resume_id;
    private String name;
    private String tel;
    private String email;
    private String profile_picture_filename;
    private String introduction;
    private String contact_time_start;
    private String contact_time_end;
    private String desired_wage;
    private String gender;
    private LocalDate birthday;
    private String location;
    private String mainservice;
    private String status;
}
