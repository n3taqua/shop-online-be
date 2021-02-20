package com.truong.shop.utils.exception;

public class NotExistException extends Exception{
    @Override
    public String getMessage() {
        return "It is not exist";
    }
}
