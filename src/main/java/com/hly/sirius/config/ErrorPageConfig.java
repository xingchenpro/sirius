package com.hly.sirius.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/2
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

    /**
     * 配置错误页面
     * @param errorPageRegistry
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
        //1、按错误的类型显示错误的网页
        //错误类型为404，找不到网页的，默认显示404.html网页
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        //错误类型为500，表示服务器响应错误，默认显示500.html网页
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        errorPageRegistry.addErrorPages(e404, e500);
    }

}
