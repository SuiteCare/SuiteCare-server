package com.suitecare.suitecare.api.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationSearchRequestDTO {
    private String search_input;
    private String[] gender;
    private String[] location;
    private Integer[] wage;
}
