package com.hly.sirius.controller;


import com.hly.sirius.dao.WebInfoDao;
import com.hly.sirius.domain.Article;
import com.hly.sirius.domain.Category;
import com.hly.sirius.domain.WebInfo;
import com.hly.sirius.service.ArticleService;
import com.hly.sirius.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/11
 */
@Controller
@RequestMapping("/article")
public class ArticleViewController {

    @Autowired
    WebInfoDao webInfoDao;

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    private static int articleNum;

    /**
     * 根据文章id获得文章
     *
     * @param id
     * @return
     */
    @RequestMapping("/detail/{id}")
    public ModelAndView getArticleDetail(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        articleService.updateArticleViewCount(id);
        Article article = articleService.getArticleById(id);
        Article preArticle = articleService.getPreArticle(id);
        Article nextArticle = articleService.getNextArticle(id);
        //更新网站访问次数
        webInfoDao.updateWebViewNum();
        //System.err.println(article.getArticleTitle()+" "+preArticle.toString()+" "+nextArticle.toString());
        mv.addObject("article", article);
        if (preArticle != null)
            mv.addObject("preArticle", preArticle);
        if (nextArticle != null)
            mv.addObject("nextArticle", nextArticle);
        mv.setViewName("/article/article_detail");
        return mv;
    }

    /**
     * 文章历史信息
     *
     * @return
     */
    @RequestMapping("/history")
    public ModelAndView getHistoryArticles() {

        ModelAndView modelAndView = new ModelAndView();
        List<Category> categoryList = categoryService.getCategories();
        System.err.println(categoryList);
        List<Article> articleList = articleService.getArticleList(new HashMap<>());
        //获得文章分类和文章信息
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("articleList", articleList);
        articleNum = articleList.size();
        modelAndView.addObject("categoryNum", articleNum);
        modelAndView.setViewName("/article/article_history");
        return modelAndView;
    }

    /**
     * 根据分类查找文章信息
     *
     * @param id
     * @return
     */
    @RequestMapping("category/{id}")
    public ModelAndView getArticleByCategory(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categoryList = categoryService.getCategories();
        Map<String, Object> articleMap = new HashMap<>();
        articleMap.put("categoryId", id);
        List<Article> articleList = articleService.getArticleByCategoryId(articleMap);
        modelAndView.addObject("categoryNum", articleNum);
        modelAndView.addObject("articleList", articleList);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.setViewName("/article/article_history");
        return modelAndView;

    }
}
