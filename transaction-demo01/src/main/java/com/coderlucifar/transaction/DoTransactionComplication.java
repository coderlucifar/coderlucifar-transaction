package com.coderlucifar.transaction;

import org.springframework.transaction.support.TransactionSynchronization;


public class DoTransactionComplication implements TransactionSynchronization {

    private Runnable runnable;

    public DoTransactionComplication(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void afterCompletion(int status) {
        if (status == TransactionSynchronization.STATUS_COMMITTED) {
            this.runnable.run();
        }
    }
}
