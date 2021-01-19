package com.xiangcm.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserDaoImpl
 * @Description: TODO
 * @Author: DELL
 * @Date: 2021/1/19 21:40
 **/
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // 少钱
    @Override
    public void reduceMoney() {
        String sql = "update t_account set money = money-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");
    }
    // 多钱
    @Override
    public void addMoney() {
        String sql = "update t_account set money = money+? where username=?";
        jdbcTemplate.update(sql,100,"mary");
    }
}
