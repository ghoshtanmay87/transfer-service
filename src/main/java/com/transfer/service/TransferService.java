package com.transfer.service;

import com.transfer.model.Transaction;
import com.transfer.model.TransferData;

/**
 * This is TransferService interface for doing balance transfer between accounts
 *
 * @author Tanmay G
 *
 */
public interface TransferService {
    /**
     * performs transfer of amount between two accounts
     *
     * @param transaction {@link Transaction}
     * @return {@link TransferData}
     */
    public TransferData transfer(Transaction transaction);
}
