package com.global_exception.exceptionhandler;

public class StudentAlreadyExists extends RuntimeException {
    public StudentAlreadyExists(String str) {
        super(str);
    }
}
