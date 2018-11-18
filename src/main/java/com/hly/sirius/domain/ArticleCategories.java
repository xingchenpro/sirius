package com.hly.sirius.domain;

import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/18
 */
public class ArticleCategories {

    private Article article;
    private List<String> categoryList;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "ArticleCategories{" +
                "article=" + article +
                ", categoryList=" + categoryList +
                '}';
    }
}
