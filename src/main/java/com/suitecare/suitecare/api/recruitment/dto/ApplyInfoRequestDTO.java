package com.suitecare.suitecare.api.recruitment.dto;

import lombok.Data;

@Data
public class ApplyInfoRequestDTO {
    private Long recruitment_id;
    private String mate_id;
    private String requested_by;
}
