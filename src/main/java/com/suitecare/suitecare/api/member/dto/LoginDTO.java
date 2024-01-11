package com.suitecare.suitecare.api.member.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private Integer id;
    private String login_id;
    private String password;
}
