package com.suitecare.suitecare.api.mate_resume.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MateResumeDTO {
    private String id;
    private String profile_picture_filename;
    private String contact_time_start;
    private String contact_time_end;
    private String introduction;
    private Integer desired_wage;
    private String tel;
    private String email;
}
