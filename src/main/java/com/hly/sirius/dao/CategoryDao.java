package com.hly.sirius.dao;

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

}
