package com.suitecare.suitecare.api.custom.format;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseForm {

    private Integer code;
    private HttpStatus httpStatus;
    private String msg;
    private Integer count;
    private List<Object> result;

}
