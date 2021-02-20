package com.truong.shop.utils.exception;

public class ExistException extends Exception{
    @Override
    public String getMessage() {
        return "It it Exist";
    }
}
