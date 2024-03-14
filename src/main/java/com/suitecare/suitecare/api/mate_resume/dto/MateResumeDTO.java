package com.suitecare.suitecare.api.mate_resume.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MateResumeDTO {
    private String id;
    @JsonProperty("profile_picture_filename")
    private String profile_picture_filename;
    @JsonProperty("contact_time_start")
    private String contact_time_start;
    @JsonProperty("contact_time_end")
    private String contact_time_end;
    private String introduction;
    @JsonProperty("desired_wage")
    private Integer desired_wage;
    @JsonProperty("tel")
    private String tel;
    @JsonProperty("email")
    private String email;
}
