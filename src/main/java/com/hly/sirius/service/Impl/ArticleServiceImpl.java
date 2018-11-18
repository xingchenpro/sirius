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
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/11
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> getArticleList(Map<String, Object> map) {
        return articleDao.getArticleList(map);
    }

    @Override
    public int getArticleCount(Map<String, Object> map) {
        return articleDao.getArticleCount(map);
    }

    @Override
    public int insertArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    @Override
    public Article getArticleById(Integer articleId) {
        return articleDao.getArticleById(articleId);
    }

    @Override
    public void updateArticleViewCount(Integer articleId) {
        articleDao.updateArticleViewCount(articleId);
    }

    @Override
    public Article getPreArticle(Integer articleId) {
        return articleDao.getPreArticle(articleId);
    }

    @Override
    public Article getNextArticle(Integer articleId) {
        return articleDao.getNextArticle(articleId);
    }

    @Override
    public int addArticleCategory(Map<String, Object> map) {
        return articleDao.addArticleCategory(map);
    }


}
