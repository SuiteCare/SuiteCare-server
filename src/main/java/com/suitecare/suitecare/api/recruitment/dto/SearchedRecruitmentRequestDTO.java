package com.suitecare.suitecare.api.recruitment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchedRecruitmentRequestDTO {
    private String search_input;
    private String[] gender;
    private String[] location;
    private Integer[] wage;
    private String[] worktime;
    private Integer[] weekdays;
}
