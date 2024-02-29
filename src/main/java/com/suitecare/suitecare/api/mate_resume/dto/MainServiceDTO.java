package com.suitecare.suitecare.api.mate_resume.dto;

import com.suitecare.suitecare.api.custom.ifc.DTO;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainServiceDTO implements DTO {
    private Long id;
    private String name;
}
