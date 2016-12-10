package com.yx.statistics.config;

import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * 使用的是tomcat的jdbc数据源，并不是spring的jdbc数据源。
 */
//@Configuration
public class DataSourceConfig {

    //@Bean
    public DataSource dataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");
        return dataSource;
    }

}