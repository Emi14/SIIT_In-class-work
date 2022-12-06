package org.siit.week7.exception;

public class ValidationException extends Exception{

    public ValidationException(String message) {
        super(message);
        System.out.println("New ValidationException created");
    }
}
