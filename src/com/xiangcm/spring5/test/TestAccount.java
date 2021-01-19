package com.xiangcm.spring5.test;

import com.xiangcm.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: TestAcount
 * @Description: TODO
 * @Author: DELL
 * @Date: 2021/1/19 21:41
 **/
public class TestAccount {
    // 测试转账
    @Test
    public void testAccount(){
       ApplicationContext context =  new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
