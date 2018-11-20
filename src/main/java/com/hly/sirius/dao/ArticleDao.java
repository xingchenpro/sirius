package com.hly.sirius.dao;


import com.hly.sirius.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/11
 */
@Component
public interface ArticleDao {
    /**
     * 分页查询文章列表
     * @param map
     * @return
     */
    public List<Article> getArticleList(Map<String, Object> map);

    /**
     * 返回文章的总数量
     * @param map
     * @return
     */
    public int getArticleCount(Map<String, Object> map);

    /**
     * 添加文章
     * @param article
     * @return
     */
    public int insertArticle(Article article);

    /**
     * 根据文章id查询文章信息
     * @param articleId
     * @return
     */
    public Article getArticleById(@Param("articleId") Integer articleId);

    /**
     * 更新文章浏览量
     */
    public void updateArticleViewCount(Integer articleId);

    /**
     * 获得上一篇文章
     * @param articleId
     * @return
     */
    public Article getPreArticle(Integer articleId);

    /**
     * 获得下一篇文章
     * @param articleId
     * @return
     */
    public Article getNextArticle(Integer articleId);

    /**
     * 添加文章和所对应的类型
     * @param
     * @param
     * @return
     */
    public int addArticleCategory(Map<String, Object> map);

    /**
     * 根据分类id查询文章
     * @param
     * @return
     */
    public List<Article> getArticleByCategoryId(Map<String,Object> map);


    /**
     * 返回每个月的文章数
     * @return
     */
    public List<Map<String,Object>> getArticleByMonth();

}
