package com.hly.sirius.service;

import com.hly.sirius.domain.Article;

import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/11
 */
public interface ArticleService {

    /**
     * 分页查询文章列表
     * @param map
     * @return
     */
    public List<Article> articleList(Map<String, Object> map);

    /**
     * 返回文章的总数量
     * @param map
     * @return
     */
    public int articleCount(Map<String, Object> map);
}
