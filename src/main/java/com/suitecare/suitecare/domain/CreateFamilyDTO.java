package com.suitecare.suitecare.domain;

import lombok.Data;

@Data
public class CreateFamilyDTO {
    private String id;
    private String password;
    private String name;
    private String tel;
    private String role;
    /*@JsonFormat(pattern = "yyyy.MM.dd'T'hh:mm", timezone = "Asia/Seoul")
    private Timestamp signup_date;*/
}
