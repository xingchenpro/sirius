package com.hly.sirius.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.log4j.jdbc.JDBCAppender;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/2
 */
public class ConnectionFactoryConfig  extends JDBCAppender{

    private  static interface Singleton{
        final ConnectionFactoryConfig INSTANCE = new ConnectionFactoryConfig();
    }

    private DruidDataSource dataSource;

    @Override
    public Connection getConnection() throws SQLException {
        System.err.println("实例化");
        Properties properties = new Properties();
        String user = "root";
        String password = "roof";
        String url = "jdbc:mysql://localhost:3306/sirius?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String driverClassName = "com.mysql.jdbc.Driver";
        properties.setProperty("user",user);
        properties.setProperty("password",password);
        properties.setProperty("url",url);
        properties.setProperty("driverClassName",driverClassName);

        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  dataSource.getConnection();
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();

    }






}
