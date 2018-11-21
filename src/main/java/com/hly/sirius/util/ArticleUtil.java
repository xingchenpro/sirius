package com.hly.sirius.util;

import com.hly.sirius.domain.Category;
import com.hly.sirius.domain.Page;
import com.hly.sirius.service.ArticleService;
import com.hly.sirius.service.CategoryService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/20
 */

public class ArticleUtil {

    /**
     * 根据Map返回Model,封装简化Controller代码
     * @param map 文章查询参数
     * @param articleService 文章查询接口
     * @param categoryService 分类查询接口
     * @return 视图参数
     */
    public static ModelAndView getArticlesList(Map<String,Object> map, String page,String url,ArticleService articleService, CategoryService categoryService){
        ModelAndView modelAndView = new ModelAndView();

        //分页查询
        if (page == null)
            page = "1";
        //当前页数，每页条数
        Page pageList = new Page(Integer.parseInt(page), 7);
        //开始查询的记录数
        map.put("start", pageList.getStart());
        //一页总记录数
        map.put("size", pageList.getlistNum());
        //得到文章数目
        Integer articleNum = articleService.getArticleCount(map);
        //得到所有分类信息
        List<Category> categoryList = categoryService.getCategories();
        //得到文章按月份分类信息
        List<Map<String,Object>> articleByMonthMapList = articleService.getArticleByMonth();

        modelAndView.addObject("categoryList",categoryList);
        modelAndView.addObject("articleNum",articleNum);
        modelAndView.addObject("articleByMonthMapList",articleByMonthMapList);
        modelAndView.addObject("pageCode", PageUtil.pageInfo(url, articleService.getArticleCount(map), Integer.parseInt(page), pageList.getlistNum()));
        return modelAndView;
    }


}
