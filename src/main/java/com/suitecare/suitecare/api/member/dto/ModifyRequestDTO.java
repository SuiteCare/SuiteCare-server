package com.suitecare.suitecare.api.member.dto;

import lombok.Data;

@Data
public class ModifyRequestDTO {
    private Long login_id;
    private String tel;
}
