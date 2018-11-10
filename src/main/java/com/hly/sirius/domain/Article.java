package com.hly.sirius.domain;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/7/12
 */

/**
 * 文章实体类
 */
public class Article {
    //12属性
    private Integer articleId;
    private String articleCreatorId;
    private String articleTitle;
    private String articleContent;
    private String articleCategoryIds;
    private String articleTags;
    private String articleCreateTime;
    private String articleCommentStatus;
    private String articleStatus;
    private Integer articleViewCount;
    private Integer articleCommentCount;
    private Integer articleLikeCount;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleCreatorId() {
        return articleCreatorId;
    }

    public void setArticleCreatorId(String articleCreatorId) {
        this.articleCreatorId = articleCreatorId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleCategoryIds() {
        return articleCategoryIds;
    }

    public void setArticleCategoryIds(String articleCategoryIds) {
        this.articleCategoryIds = articleCategoryIds;
    }

    public String getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(String articleTags) {
        this.articleTags = articleTags;
    }

    public String getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(String articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public String getArticleCommentStatus() {
        return articleCommentStatus;
    }

    public void setArticleCommentStatus(String articleCommentStatus) {
        this.articleCommentStatus = articleCommentStatus;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getArticleViewCount() {
        return articleViewCount;
    }

    public void setArticleViewCount(Integer articleViewCount) {
        this.articleViewCount = articleViewCount;
    }

    public Integer getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Integer articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Integer getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Integer articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleCreatorId='" + articleCreatorId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleCategoryIds='" + articleCategoryIds + '\'' +
                ", articleTags='" + articleTags + '\'' +
                ", articleCreateTime='" + articleCreateTime + '\'' +
                ", articleCommentStatus='" + articleCommentStatus + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                ", articleViewCount=" + articleViewCount +
                ", articleCommentCount=" + articleCommentCount +
                ", articleLikeCount=" + articleLikeCount +
                '}';
    }
}
