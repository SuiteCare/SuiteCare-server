package com.suitecare.suitecare.api.custom.exception;

import com.suitecare.suitecare.api.custom.format.ResponseForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<ResponseForm> handlePersistenceException(PersistenceException e) {
        log.info("PersistenceException 발생");

        // 예외 처리 로직
        ResponseForm responseForm = ResponseForm.builder()
                                                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                                                .msg("Mybatis DB 처리 과정에서 Error 가 발생했습니다.")
                                                .count(1)
                                                .result(List.of(e.getMessage()))
                                                .build();

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResponseForm> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        log.info("SQLIntegrityConstraintViolationException 발생");

        // 예외 처리 로직
        ResponseForm responseForm = ResponseForm.builder()
                                                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                                                .msg("DB 제약조건 위반 Error 가 발생했습니다.")
                                                .count(1)
                                                .result(List.of(e.getMessage()))
                                                .build();

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public ResponseEntity<ResponseForm> handleSQLSyntaxErrorException(SQLSyntaxErrorException e) {
        log.info("SQLSyntaxErrorException 발생");

        // 예외 처리 로직
        ResponseForm responseForm = ResponseForm.builder()
                                                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                                                .msg("SQL 문법 Error 가 발생했습니다.")
                                                .count(1)
                                                .result(List.of(e.getMessage()))
                                                .build();

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }
}