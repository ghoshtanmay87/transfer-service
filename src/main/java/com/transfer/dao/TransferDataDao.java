package com.transfer.dao;

import com.transfer.model.TransferData;

/**
 * This is TransferDataDao interface to access TransferData from database
 *
 * @author Tanmay G
 *
 */
public interface TransferDataDao {
    /**
     * stores transfer data in database
     *
     * @param transferData {@link TransferData}
     *
     */
    public void saveTransferData(TransferData transferData);
}
