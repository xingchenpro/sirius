package com.hly.sirius.service.Impl;

import com.hly.sirius.dao.WebInfoDao;
import com.hly.sirius.domain.WebInfo;
import com.hly.sirius.service.WebInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/30
 */
@Service
public class WebInfoServiceImpl implements WebInfoService{

    @Autowired
    WebInfoDao webInfoDao;


    @Override
    public WebInfo getWebInfo() {
        return webInfoDao.getWebInfo();
    }

    @Override
    public int updateWebViewNum() {
        return webInfoDao.updateWebViewNum();
    }
}
