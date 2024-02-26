package com.suitecare.suitecare.api.mate_resume.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MateResumeDTO {
    private String id;
    @JsonProperty("profile_picture_filename")
    private String profilePictureFilename;
    @JsonProperty("contact_time_start")
    private String contactTimeStart;
    @JsonProperty("contact_time_end")
    private String contactTimeEnd;
    private String introduction;
    @JsonProperty("desired_wage")
    private Integer desiredWage;
}
