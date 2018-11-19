package com.hly.sirius.controller;

import com.hly.sirius.domain.Article;
import com.hly.sirius.domain.Category;
import com.hly.sirius.domain.Page;
import com.hly.sirius.service.ArticleService;
import com.hly.sirius.service.CategoryService;
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
public class MainController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    private static Integer articleNum;
    /**
     * 请求文章列表
     *
     * @return article list
     */
    @RequestMapping({"/index","/"})
    public ModelAndView getArticleList(@RequestParam(value = "page", required = false) String page, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (page == null)
            page = "1";
        //当前页数，每页条数
        Page pageList = new Page(Integer.parseInt(page), 7);
        Map<String, Object> listMap = new HashMap<String, Object>();
        //开始查询的记录数
        listMap.put("start", pageList.getStart());
        //一页总记录数
        listMap.put("size", pageList.getlistNum());
        //当前页数
        //listMap.put("page",Integer.parseInt(page));
        List<Article> articleList = articleService.getArticleList(listMap);
        //个人信息
        //文章分类信息
        List<Category> categoryList = categoryService.getCategories();
        articleNum = articleService.getArticleCount(listMap);
        mv.addObject("articleNum",articleNum);
        mv.addObject("categoryList",categoryList);
        //文章归档信息
        mv.addObject("articleList", articleList);
        //System.err.println("文章总数:" + articleService.getArticleCount(listMap));
        //System.err.println("page:"+PageUtil.pageInfo(request.getContextPath()+"/article",articleService.articleCount(listMap),Integer.parseInt(page),7));
        mv.addObject("pageCode", PageUtil.pageInfo(request.getContextPath() + "/index", articleService.getArticleCount(listMap), Integer.parseInt(page), pageList.getlistNum()));
        mv.setViewName("article/article_index");
        return mv;
    }

    @RequestMapping("/index/category/{id}")
    public ModelAndView getArticleByCategory(@PathVariable("id")Integer id,@RequestParam(value = "page", required = false) String page, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
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
        List<Article> articleList = articleService.getArticleByCategoryId(articleMap);
        List<Category> categoryList = categoryService.getCategories();
        modelAndView.addObject("articleNum",articleNum);
        modelAndView.addObject("categoryList",categoryList);
        modelAndView.addObject("articleList",articleList);
        modelAndView.addObject("pageCode", PageUtil.pageInfo(request.getContextPath() + "/index/category/"+id, articleService.getArticleCount(articleMap), Integer.parseInt(page), pageList.getlistNum()));
        modelAndView.setViewName("article/article_index");
        return modelAndView;

    }







}
