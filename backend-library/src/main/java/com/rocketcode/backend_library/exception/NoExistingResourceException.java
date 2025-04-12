package com.rocketcode.backend_library.exception;

public class NoExistingResourceException extends RuntimeException{
    public NoExistingResourceException(String msg) { super(msg);}
}
