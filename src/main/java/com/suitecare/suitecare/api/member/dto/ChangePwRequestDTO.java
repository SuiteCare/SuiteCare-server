package com.suitecare.suitecare.api.member.dto;

import lombok.Data;

@Data
public class ChangePwRequestDTO {
    private int login_id;
    private String password;
}