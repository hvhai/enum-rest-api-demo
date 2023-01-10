package com.codehunter.enumrestapidemo;

public class UnknownEnumValueException extends RuntimeException{
    public UnknownEnumValueException(String message) {
        super(message);
    }
}
