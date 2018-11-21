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

        //查询文章的参数
        Map<String, Object> articleMap = new HashMap<String, Object>();
        //得到文章数目，分类，年月分类信息
        ModelAndView modelAndView = ArticleUtil.getArticlesList(articleMap,page,request.getContextPath() + "/index",articleService,categoryService);
        //所有文章信息
        List<Article> articleList = articleService.getArticleList(articleMap);
         modelAndView.addObject("articleList", articleList);
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

        Map<String,Object> articleMap = new HashMap<>();
        //得到文章数目，分类，年月分类信息
        ModelAndView modelAndView = ArticleUtil.getArticlesList(articleMap,page,request.getContextPath() + "/index/category/"+id,articleService,categoryService);
        //类型id
        articleMap.put("categoryId",id);
        //查询该分类所有文章
        List<Article> articleList = articleService.getArticleByCategoryId(articleMap);
          modelAndView.addObject("articleList",articleList);
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

        Map<String,Object> articleMap = new HashMap<>();
        //得到文章数目，分类，年月分类信息
        ModelAndView modelAndView = ArticleUtil.getArticlesList(articleMap,page,request.getContextPath() + "/index/time/"+year+"/"+month,articleService,categoryService);
        //得到文章信息
        articleMap.put("createYear",year);
        articleMap.put("createMonth",month);
        List<Article> articleList = articleService.getArticleList(articleMap);
        modelAndView.addObject("articleList", articleList);
        modelAndView.setViewName("article/article_index");
        return modelAndView;

    }
}
