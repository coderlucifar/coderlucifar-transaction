package com.coderlucifar.transaction.service;

import com.coderlucifar.transaction.DoTransactionComplication;
import com.coderlucifar.transaction.TransactionUtils;
import com.coderlucifar.transaction.dao.UserDao;
import com.coderlucifar.transaction.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class UserService {

    @Resource
    UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public void doTx() {

        System.out.println("start tx");

        userDao.insertUser(new User(2, "flash"));
//        int i = 1 / 0;

        // 事务执行成功后的回调逻辑
//        TransactionUtils.doAfterTransaction(new DoTransactionComplication(
//                () -> {
//                    System.out.println("事务执行成功后的回调操作，比如mq消息");
//                }
//        ));
        // 优化：更好的封装性，业务调用方并不需要知道关于类DoTransactionComplication的信息
        // 减少了耦合
        TransactionUtils.doAfterTransaction(() -> {
            System.out.println("事务执行成功后的回调操作，比如mq消息");
        });



        System.out.println("end tx");

    }

}
