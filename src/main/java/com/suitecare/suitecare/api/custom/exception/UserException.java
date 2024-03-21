package com.suitecare.suitecare.api.custom.exception;

public class UserException {
    public static class SamePasswordException extends RuntimeException { // 기존 비밀번호와 새 비밀번호 동일
        public SamePasswordException(String message) {
            super(message);
        }
    }

    public static class NotMatchPasswordException  extends RuntimeException { // 현재 비밀번호 일치 X
        public NotMatchPasswordException (String message) {
            super(message);
        }
    }
}
