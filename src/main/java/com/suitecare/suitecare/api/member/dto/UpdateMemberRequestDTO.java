package com.suitecare.suitecare.api.member.dto;

import lombok.Data;

@Data
public class UpdateMemberRequestDTO {
    private String tel;
    private String gender;
    private String email;
}
