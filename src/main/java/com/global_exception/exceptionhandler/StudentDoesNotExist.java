package com.global_exception.exceptionhandler;

public class StudentDoesNotExist extends RuntimeException {
    public StudentDoesNotExist(String str) {
        super(str);
    }
}
