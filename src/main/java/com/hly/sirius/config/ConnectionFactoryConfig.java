package com.hly.sirius.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/2
 */
public class ConnectionFactoryConfig  {

    private DruidDataSource dataSource;

    private  static ConnectionFactoryConfig connectionFactoryConfig;

    private Connection getConnection() throws SQLException {
        //System.err.println("实例化");
        Properties properties = new Properties();
        String user = "root";
        String password = "roof";
        String url = "jdbc:mysql://mysql:3306/sirius?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String driverClassName = "com.mysql.jdbc.Driver";
        properties.put("driverClassName",driverClassName);
        properties.put("url",url);
        properties.put("username",user);
        properties.put("password",password);
        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            try {
               init();
            } catch (Exception e2) {
            }
        }
        return  dataSource.getConnection();
    }

    public static Connection getDatabaseConnection() throws SQLException {
       if(connectionFactoryConfig==null){
           connectionFactoryConfig = new ConnectionFactoryConfig();
       }
       return connectionFactoryConfig.getConnection();

    }

    public void init(){
        try {
            if (dataSource != null)
                dataSource.close();
        } catch (Exception e) {
        }
    }
}
