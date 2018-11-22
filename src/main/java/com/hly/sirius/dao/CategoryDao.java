package com.hly.sirius.dao;

import com.hly.sirius.domain.Article;
import com.hly.sirius.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/18
 */
@Repository
public interface CategoryDao {


    /**
     * 查询所有分类信息
     * @return
     */
    public List<Category> getCategories ();

    /**
     * 插入分类
     * @param
     * @return
     */
    public int addCategory(Category category);

    /**
     * 查询某一类
     * @param Category
     * @return
     */
    public Integer  getCategory(String Category);

    /**
     * 更新分类的数目
     * @param categoryNum
     * @return
     */
    public int updateCategoryNum(String categoryNum);

    /**
     * 根据文章id查询对应的分类
     * @param articleId
     * @return
     */
    public List<Category> getCategoriesByArticleId(Integer articleId);



}
