package com.hly.sirius.service;

import com.hly.sirius.domain.WebInfo;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/30
 */
public interface WebInfoService {

    /**
     * 获取网站信息
     * @return
     */
    public WebInfo getWebInfo();

    /**
     * 更新网站访问量
     * @return
     */
    public int updateWebViewNum();
}
