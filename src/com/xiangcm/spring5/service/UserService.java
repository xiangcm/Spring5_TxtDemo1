package com.xiangcm.spring5.service;

import com.xiangcm.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: DELL
 * @Date: 2021/1/19 21:40
 **/
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {
    @Autowired
    private UserDao userDao;
    // 转账方法
    public void accountMoney(){
        // lucy 少 100
        userDao.reduceMoney();
        int a = 1/0;
        // mary 多 100
        userDao.addMoney();
    }
}
