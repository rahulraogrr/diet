package com.diet.exceptions.custom;

public class NotFoundException extends RuntimeException {

    private Class clazz;
    private String searchParameter;

    public NotFoundException() {
        this("Resource Not Found");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Class clazz,String searchParameter) {
        super(clazz.getSimpleName()+" was not found for parameters "+searchParameter);
    }
}