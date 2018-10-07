package com.hly.sirius.service.Impl;


import com.hly.sirius.dao.ArticleDao;
import com.hly.sirius.domain.Article;
import com.hly.sirius.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/11
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> articleList(Map<String, Object> map) {
        return articleDao.articleList(map);
    }

    @Override
    public int articleCount(Map<String, Object> map) {
        return articleDao.articleCount(map);
    }
}
