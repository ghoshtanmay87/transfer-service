package com.transfer.service.impl;

import com.transfer.dao.TransferDataDao;
import com.transfer.exception.AccountException;
import com.transfer.exception.TransferServiceException;
import com.transfer.model.Account;
import com.transfer.model.TransferData;
import com.transfer.model.Transaction;
import com.transfer.service.AccountService;
import com.transfer.service.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * This is TransferService implementation for doing balance transfer between accounts
 *
 * @author Tanmay G
 *
 */
@Service
public class TransferServiceImpl implements TransferService {
    private final AccountService accountService;
    private final TransferDataDao transferDataDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TransferServiceImpl(AccountService accountService, TransferDataDao transferDataDao){
        this.accountService = accountService;
        this.transferDataDao = transferDataDao;
    }

    @Override
    @Transactional
    public TransferData transfer(Transaction transaction) {
        Account sourceAccount = accountService.getByAccountNo(transaction.getSourceAccountNo());
        Account destinationAccount = accountService.getByAccountNo(transaction.getDestinationAccountNo());
        if(sourceAccount.getBalance().compareTo(transaction.getAmount()) < 0){
            throw new AccountException("Insufficient balance in source transfer");
        }
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(transaction.getAmount()));
        destinationAccount.setBalance(destinationAccount.getBalance().add(transaction.getAmount()));
        accountService.saveAccount(sourceAccount);
        accountService.saveAccount(destinationAccount);
        TransferData transferData = new TransferData().
                setTransactionId(UUID.randomUUID().toString()).
                setSourceAccountNo(sourceAccount.getAccountNo()).
                setDestinationAccountNo(destinationAccount.getAccountNo()).
                setAmount(transaction.getAmount()).
                setTransactionTime(new Date()).
                setTransactionStatus(TransferData.TransactionStatus.SUCCESS);
        try{
            transferDataDao.saveTransferData(transferData);
        }
        catch (DataAccessException ex){
            throw new TransferServiceException("Error accessing Account data", ex);
        }
        logger.debug("transfer successful with transferId: {}", transferData.getTransactionId());
        return transferData;
    }
}
