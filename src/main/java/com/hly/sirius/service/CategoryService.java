package com.hly.sirius.service;

import com.hly.sirius.domain.Article;
import com.hly.sirius.domain.Category;

import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/18
 */
public interface CategoryService {

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


}
