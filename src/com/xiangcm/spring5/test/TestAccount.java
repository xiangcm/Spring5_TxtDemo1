package com.xiangcm.spring5.test;

import com.xiangcm.spring5.config.TxConfigration;
import com.xiangcm.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @ClassName: TestAcount
 * @Description: 测试类
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

    @Test
    public void testAccount2(){
        ApplicationContext context =  new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void testAccount3(){
        ApplicationContext context =  new AnnotationConfigApplicationContext(TxConfigration.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
