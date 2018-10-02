package com.hly.sirius.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.log4j.jdbc.JDBCAppender;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.spi.ErrorCode;

public class ConnectionFactory extends JDBCAppender {
    /* Druid数据源 */
    private DruidDataSource dataSource;
    private static ConnectionFactory connectionFactory;
    public ConnectionFactory() {
        super();
    }

    @Override
    protected void closeConnection(Connection con) {
        try {
            /* 如果数据库连接对象不为空和没有被关闭的话，关闭数据库连接 */
            if (con != null && !con.isClosed())
                con.close();
        } catch (SQLException e) {
            errorHandler.error("Error closing MyJDBCAppender.closeConnection() 's connection", e, org.apache.log4j.spi.ErrorCode.GENERIC_FAILURE);
        }
    }

    @Override
    protected Connection getConnection() throws SQLException {
        String className = "com.mysql.jdbc.Driver";
        String connUrl = "jdbc:mysql://localhost:3306/jsjxy?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String uname = "root";
        String psw = "roof";
        Properties result = new Properties();
        result.put("driverClassName", className);
        result.put("url", connUrl);
        result.put("username", uname);
        result.put("password", psw);

        /* 其他配置 自然你也可以自己写property 然后获取set */
        result.put("maxActive", "30");
        result.put("minIdle", "3");

        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(result);
        } catch (Exception e) {
            /* Druid数据库源对象产生失败后，取消初始化 */
            try {
                uninitialize();
            } catch (Exception e2) {
            }
        }

        return dataSource.getConnection();
    }

    /* 取消初始化 */
    public void uninitialize() {
        try {
            if (dataSource != null)
                dataSource.close();
        } catch (Exception e) {
        } finally {
            super.close();
        }
    }
    public static Connection getDataSourceConnection() throws SQLException {
        if (connectionFactory==null){
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory.getConnection();
    }

}
