package com.transfer.handler;

import com.transfer.exception.AccountException;
import com.transfer.exception.TransactionConflictException;
import com.transfer.exception.TransferServiceException;
import com.transfer.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This is Exception Handler to handle generic and standard error responses for all error scenarios
 *
 * @author Tanmay G
 *
 */
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Handles {@link AccountException}
     *
     * @param ex {@link AccountException}
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorResponse> handlerForAccountException(AccountException ex){
        logger.error("AccountException occurred: ", ex);
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage(),
                HttpStatus.BAD_REQUEST.name()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles {@link TransferServiceException}
     *
     * @param ex {@link TransferServiceException}
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(TransferServiceException.class)
    public ResponseEntity<ErrorResponse> handlerForTransferException(TransferServiceException ex){
        logger.error("TransferServiceException occurred: ", ex);
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.name()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles {@link TransactionConflictException}
     *
     * @param ex {@link TransactionConflictException}
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(TransactionConflictException.class)
    public ResponseEntity<ErrorResponse> handlerForTransactionConflictException(TransactionConflictException ex){
        logger.error("TransactionConflictException occurred: ", ex);
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage(),
                HttpStatus.CONFLICT.name()), HttpStatus.CONFLICT);
    }

    /**
     * Handles {@link Exception}
     *
     * @param ex {@link Exception}
     * @return {@link ErrorResponse}
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerForGenericException(Exception ex){
        logger.error("Generic Exception occurred: ", ex);
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.name()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
