package com.coderlucifar.transaction;

import org.springframework.transaction.support.TransactionSynchronizationManager;


public class TransactionUtils {

//    public static void doAfterTransaction(DoTransactionComplication doTransactionComplication) {
//        if (TransactionSynchronizationManager.isActualTransactionActive()) {
//            TransactionSynchronizationManager.registerSynchronization(doTransactionComplication);
//        }
//    }

    // 优化
    public static void doAfterTransaction(Runnable runnable ) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronizationManager.registerSynchronization(new DoTransactionComplication(runnable));
        }
    }

}


