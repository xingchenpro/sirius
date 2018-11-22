package com.hly.sirius.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/2
 */
//这种方法的filter按文件名顺序执行
@WebFilter(filterName = "UserFilter", urlPatterns = {"/admin/articleWriting","/user/login"})
public class UserFilter extends OncePerRequestFilter {

    private static Logger logger = LogManager.getLogger(UserFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("username");
        String userIP = request.getRemoteAddr();
        ThreadContext.put("userId", userId);
        ThreadContext.put("userIP", userIP);
        System.err.println("登录用户：" + userId);
        System.err.println("登录IP：" + userIP);
        logger.error("用户：" + userId);
        //寻找下一个链，没有则跳转页面
        filterChain.doFilter(request, response);
    }
}
