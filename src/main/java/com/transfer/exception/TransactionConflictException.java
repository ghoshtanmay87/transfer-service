package com.transfer.exception;

/**
 * This Exception class is used for optimistic locking failures for concurrent transactions and to avoid dirty reads
 *
 * @author Tanmay G
 *
 */
public class TransactionConflictException extends RuntimeException{
    public TransactionConflictException(){
        super();
    }
    public TransactionConflictException(String message){
        super(message);
    }
    public TransactionConflictException(Throwable throwable){
        super(throwable);
    }
    public TransactionConflictException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
