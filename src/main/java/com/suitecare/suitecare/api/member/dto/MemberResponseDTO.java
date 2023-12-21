package com.suitecare.suitecare.api.member.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class MemberResponseDTO {
    @NonNull
    private Long id;
    private String login_id;
    private String password;
    private String name;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date birthday;
    private String email;
    private String tel;
    private String address;
    private String address_detail;
    private String role;
    @JsonFormat(pattern = "yyyy.MM.dd'T'hh:mm", timezone = "Asia/Seoul")
    private Timestamp create_at;
    @JsonFormat(pattern = "yyyy.MM.dd'T'hh:mm", timezone = "Asia/Seoul")
    private Timestamp update_at;
}
