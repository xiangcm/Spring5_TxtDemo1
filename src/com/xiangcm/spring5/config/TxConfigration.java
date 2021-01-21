package com.xiangcm.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @ClassName: TxConfigration
 * @Description: 配置类
 * @Author: DELL
 * @Date: 2021/1/21 22:50
 **/
@Configuration // 配置类
@ComponentScan(basePackages = "com.xiangcm.spring5") // 组件扫描
@EnableTransactionManagement // 开启事务
public class TxConfigration {
    // 创建数据库连接
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring5?serverTimezone=GMT%2B8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123");
        return  druidDataSource;
    }

    // 创建JdbcTemplate对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 注入dataSource
        jdbcTemplate.setDataSource(dataSource);
        return  jdbcTemplate;
    }

    // 创建事务管理器对象
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager =
                new DataSourceTransactionManager();
        // 根据类型找到对应的DataSource
        dataSourceTransactionManager.setDataSource(dataSource);
        return  dataSourceTransactionManager;
    }
}
