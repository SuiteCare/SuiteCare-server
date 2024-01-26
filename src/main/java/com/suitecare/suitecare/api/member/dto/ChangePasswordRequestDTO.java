package com.suitecare.suitecare.api.member.dto;

import lombok.Data;

@Data
public class ChangePasswordRequestDTO {
    private Long login_id;
    private String originPassword;
    private String newPassword;
    private String newPasswordCheck;
}
