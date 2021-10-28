package com.transfer.controller;

import com.transfer.model.Transaction;
import com.transfer.model.TransferData;
import com.transfer.validator.RequestValidator;
import com.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is {@link @RestController} Spring controller class to handle incoming requests for Balance Transfer
 *
 * @author Tanmay G
 *
 */

@RestController
public class TransferController {
    private final TransferService transferService;
    private final RequestValidator<Transaction> requestValidator;

    @Autowired
    public TransferController(TransferService transferService, RequestValidator requestValidator){
        this.transferService = transferService;
        this.requestValidator = requestValidator;
    }

    /**
     * Handler method for POST call to perform balance transfer between accounts.
     *
     * @param transaction {@link Transaction} transaction
     * @return {@link TransferData}
     */
    @RequestMapping(method = RequestMethod.POST, path = "/api/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransferData> transferMoney(@RequestBody Transaction transaction) {
        requestValidator.validate(transaction);
        return new ResponseEntity<TransferData>(transferService.transfer(transaction), HttpStatus.OK);
    }
}
