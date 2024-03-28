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

    @ExceptionHandler(UserException.SamePasswordException.class)
    public ResponseEntity<ResponseForm> handleSamePasswordException(UserException.SamePasswordException e) {
        ResponseForm responseForm = ResponseForm.builder()
                                                .code(HttpStatus.CONFLICT.value())
                                                .httpStatus(HttpStatus.CONFLICT)
                                                .msg(e.getMessage())
                                                .count(0)
                                                .result(List.of(e.getMessage()))
                                                .build();

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    @ExceptionHandler(UserException.NotMatchPasswordException.class)
    public ResponseEntity<ResponseForm> handleNotMatchPasswordException(UserException.NotMatchPasswordException e) {
        ResponseForm responseForm = ResponseForm.builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .httpStatus(HttpStatus.UNAUTHORIZED)
                .msg(e.getMessage())
                .count(0)
                .result(List.of(e.getMessage()))
                .build();


        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 간병인의 이력서가 없는 경우 */
    public static class ResumeNotFoundException extends RuntimeException {
        public ResumeNotFoundException (String message) {
            super(message);
        }
    }

    @ExceptionHandler(ResumeNotFoundException.class)
    public ResponseEntity<ResponseForm> handleResumeNotFoundException(ResumeNotFoundException e) {
        ResponseForm responseForm = ResponseForm.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .httpStatus(HttpStatus.NOT_FOUND)
                .msg(e.getMessage())
                .count(0)
                .result(List.of(e.getMessage()))
                .build();


        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 이미 지원한 공고인 경우 */
    public static class AlreadyAppliedException extends RuntimeException {
        public AlreadyAppliedException (String message) {
            super(message);
        }
    }

    @ExceptionHandler(AlreadyAppliedException.class)
    public ResponseEntity<ResponseForm> handleAlreadyAppliedException(AlreadyAppliedException e) {
        ResponseForm responseForm = ResponseForm.builder()
                .code(HttpStatus.CONFLICT.value())
                .httpStatus(HttpStatus.CONFLICT)
                .msg(e.getMessage())
                .count(0)
                .result(List.of(e.getMessage()))
                .build();


        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 이미 확정된 공고 */
    public static class AlreadyReservedException extends RuntimeException {
        public AlreadyReservedException (String message) {
            super(message);
        }
    }

    @ExceptionHandler(AlreadyReservedException.class)
    public ResponseEntity<ResponseForm> handleAlreadyReservedException(AlreadyReservedException e) {
        ResponseForm responseForm = ResponseForm.builder()
                .code(HttpStatus.CONFLICT.value())
                .httpStatus(HttpStatus.CONFLICT)
                .msg(e.getMessage())
                .count(0)
                .result(List.of(e.getMessage()))
                .build();


        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* status에 대한 업데이트 결과가 없는 경우 */
    public static class UpdateStatusException extends RuntimeException {
        public UpdateStatusException (String message) {
            super(message);
        }
    }

    @ExceptionHandler(UpdateStatusException.class)
    public ResponseEntity<ResponseForm> handleUpdateStatusException(UpdateStatusException e) {
        ResponseForm responseForm = ResponseForm.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .msg(e.getMessage())
                .count(0)
                .result(List.of(e.getMessage()))
                .build();


        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 지원자 목록에 없는 경우 */
    public static class ApplicantNotFoundException extends RuntimeException {
        public ApplicantNotFoundException (String message) {
            super(message);
        }
    }

    @ExceptionHandler(ApplicantNotFoundException.class)
    public ResponseEntity<ResponseForm> handleApplicantNotFoundException(ApplicantNotFoundException e) {
        ResponseForm responseForm = ResponseForm.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .msg(e.getMessage())
                .count(0)
                .result(List.of(e.getMessage()))
                .build();


        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }
}