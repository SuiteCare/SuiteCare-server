package com.suitecare.suitecare.api.mate_resume.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MateResumeDTO {
    private String id;
    private MultipartFile profile_picture_filename;
    private String contact_time_start;
    private String contact_time_end;
    private String introduction;
    private Integer desired_wage;
    private String tel;
    private String email;
}
