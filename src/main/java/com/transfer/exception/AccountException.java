package com.transfer.exception;

/**
 * This Exception class is used for any Account related validation failures
 *
 * @author Tanmay G
 *
 */
public class AccountException extends RuntimeException{
    public AccountException(){
        super();
    }
    public AccountException(String message){
        super(message);
    }
    public AccountException(Throwable throwable){
        super(throwable);
    }
    public AccountException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
