package com.hly.sirius.dao;

import com.hly.sirius.domain.WebInfo;
import org.springframework.stereotype.Repository;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/30
 */
@Repository
public interface WebInfoDao {

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
