package com.hly.sirius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/2
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 403页面
     */
    @RequestMapping(value = "/403")
    public String error_403() {
        return "/error/403";
    }

    /**
     * 500页面
     */
    @RequestMapping(value = "/500")
    public String error_500() {
        return "/error/500";
    }

    /**
     * 404页面
     */
    @RequestMapping(value = "/404")
    public String error_404() {
        return "/error/404";
    }
}
