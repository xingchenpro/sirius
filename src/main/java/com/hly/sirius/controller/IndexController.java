package com.hly.sirius.controller;

import com.hly.sirius.domain.Article;
import com.hly.sirius.domain.Page;
import com.hly.sirius.service.ArticleService;
import com.hly.sirius.service.CategoryService;
import com.hly.sirius.util.ArticleUtil;
import com.hly.sirius.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/16
 */
@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;
    /**
     * 请求文章列表
     *
     * @return article list
     */
    @RequestMapping({"/index","/"})
    public ModelAndView getArticlesList(@RequestParam(value = "page", required = false) String page, HttpServletRequest request) {

        if (page == null)
            page = "1";
        //当前页数，每页条数
        Page pageList = new Page(Integer.parseInt(page), 7);
        //查询文章的参数
        Map<String, Object> articleMap = new HashMap<String, Object>();
        //开始查询的记录数
        articleMap.put("start", pageList.getStart());
        //一页总记录数
        articleMap.put("size", pageList.getlistNum());
        //所有文章信息
        List<Article> articleList = articleService.getArticleList(articleMap);
        //得到文章数目，分类，年月分类信息
        ModelAndView modelAndView = ArticleUtil.getArticlesList(articleMap,articleService,categoryService);
        modelAndView.addObject("articleList", articleList);
        modelAndView.addObject("pageCode", PageUtil.pageInfo(request.getContextPath() + "/index", articleService.getArticleCount(articleMap), Integer.parseInt(page), pageList.getlistNum()));
        modelAndView.setViewName("article/article_index");
        return modelAndView;
    }

    /**
     * 根据分类查询文章
     * @param id
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/index/category/{id}")
    public ModelAndView getArticlesByCategory(@PathVariable("id")Integer id,@RequestParam(value = "page", required = false) String page, HttpServletRequest request){
        if (page == null)
            page = "1";
        //当前页数，每页条数
        Page pageList = new Page(Integer.parseInt(page), 7);
        //根据分类查找文章
        Map<String,Object> articleMap = new HashMap<>();
        //开始查询的记录数
        articleMap.put("start", pageList.getStart());
        //一页总记录数
        articleMap.put("size", pageList.getlistNum());
        //类型id
        articleMap.put("categoryId",id);
        //查询该分类所有文章
        List<Article> articleList = articleService.getArticleByCategoryId(articleMap);
        //得到文章数目，分类，年月分类信息
        ModelAndView modelAndView = ArticleUtil.getArticlesList(articleMap,articleService,categoryService);

        modelAndView.addObject("articleList",articleList);
        modelAndView.addObject("pageCode", PageUtil.pageInfo(request.getContextPath() + "/index/category/"+id, articleService.getArticleCount(articleMap), Integer.parseInt(page), pageList.getlistNum()));
        modelAndView.setViewName("article/article_index");
        return modelAndView;
    }

    /**
     * 根据发布时间查找文章
     * @param
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/index/time/{year}/{month}")
    public ModelAndView getArticlesByMonth(@PathVariable("year")Integer year,@PathVariable("month")Integer month,@RequestParam(value = "page", required = false) String page, HttpServletRequest request){
        if (page == null)
            page = "1";
        //当前页数，每页条数
        Page pageList = new Page(Integer.parseInt(page), 7);

        Map<String,Object> articleMap = new HashMap<>();
        //得到文章数目，分类，年月分类信息
        ModelAndView modelAndView = ArticleUtil.getArticlesList(articleMap,articleService,categoryService);
        modelAndView.addObject("pageCode", PageUtil.pageInfo(request.getContextPath() + "/index/category/"+year+"/"+month, articleService.getArticleCount(articleMap), Integer.parseInt(page), pageList.getlistNum()));
        modelAndView.setViewName("article/article_index");
        return modelAndView;

    }


}
