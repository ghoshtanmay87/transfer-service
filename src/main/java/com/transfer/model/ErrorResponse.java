package com.transfer.model;

/**
 * This is model to represent an generic error response format for all error scenarios
 *
 * @author Tanmay G
 *
 */
public class ErrorResponse {
    private final TransferData.TransactionStatus status;
    private final String errorMessage;
    private final String errorCode;

    public ErrorResponse(String errorMessage, String errorCode) {
        this.status = TransferData.TransactionStatus.FAILED;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public TransferData.TransactionStatus getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
