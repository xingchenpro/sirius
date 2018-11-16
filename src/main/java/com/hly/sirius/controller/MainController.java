package com.hly.sirius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/16
 */
@Controller
public class MainController {

    /**
     * 主页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("/index");
        return mView;
    }

    /**
     * 初始化页面
     * @return
     */
    @RequestMapping("/")
    public ModelAndView preLogin(){
        ModelAndView mView = new ModelAndView();
        mView.setViewName("/user/login");
        return mView;
    }
}
