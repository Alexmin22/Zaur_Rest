package ru.spring.rest.exception_handing;

public class NoSuchEmplExcep extends RuntimeException {
    public NoSuchEmplExcep(String message) {
        super(message);
    }
}
