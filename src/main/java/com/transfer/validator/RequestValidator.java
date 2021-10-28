package com.transfer.validator;

/**
 * This is validator interface to do static validations for all incoming requests and throws appropriate validation exceptions
 *
 * @author Tanmay G
 *
 */
public interface RequestValidator<T> {
    /**
     * Fetches the Account using accountNo
     *
     * @param request request object
     *
     */
    public void validate(T request);
}
