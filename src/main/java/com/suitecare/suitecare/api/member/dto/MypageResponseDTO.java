package com.suitecare.suitecare.api.member.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class MypageResponseDTO {
    private String login_id;
    private String password;
    private String name;
    private String gender;
    private Date birthday;
    private String tel;
}
