package com.hly.sirius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/16
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin(){
        return "/admin/admin";
    }


}
