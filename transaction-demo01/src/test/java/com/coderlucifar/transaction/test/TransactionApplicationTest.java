package com.coderlucifar.transaction.test;

import com.coderlucifar.TransactionApplication;
import com.coderlucifar.transaction.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = TransactionApplication.class)
@RunWith(SpringRunner.class)
public class TransactionApplicationTest {

    @Resource
    UserService userService;

    @Test
    public void test_transaction_callback() {
        userService.doTx();
    }



}
