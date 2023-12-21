package com.suitecare.suitecare.api.mate.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class MateDTO {
    private String name;
    private String gender;
    private Date birthday;
    private String profile_picture_filename;
    private String introduction;
    private String contact_time_start;
    private String contact_time_end;
}
