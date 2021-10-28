package com.transfer.exception;

/**
 * This Exception class is used for handling generic exception in transfer service layer
 *
 * @author Tanmay G
 *
 */
public class TransferServiceException extends RuntimeException {
    public TransferServiceException(){
        super();
    }
    public TransferServiceException(String message){
        super(message);
    }
    public TransferServiceException(Throwable throwable){
        super(throwable);
    }
    public TransferServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
