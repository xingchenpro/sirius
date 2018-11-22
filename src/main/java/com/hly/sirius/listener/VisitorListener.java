package com.hly.sirius.listener;

import com.hly.sirius.dao.VisitorDao;
import com.hly.sirius.domain.Visitor;
import com.hly.sirius.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/22
 */
//@WebListener
public class VisitorListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
    /**
     * 监听访客
     * @param request
     */
    @Override
    public void requestInitialized(ServletRequestEvent request) {
        String visitorIP = request.getServletRequest().getRemoteAddr();
        String lastVisitTime = DateUtil.getCurrentDateString();
        System.err.println(visitorIP+"\n"+lastVisitTime);
    }
}
