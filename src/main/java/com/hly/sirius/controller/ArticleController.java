package com.hly.sirius.controller;


import com.hly.sirius.domain.Article;
import com.hly.sirius.domain.Page;
import com.hly.sirius.service.ArticleService;
import com.hly.sirius.util.DateUtil;
import com.hly.sirius.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 请求文章列表
     *
     * @return article list
     */
    @RequestMapping("/article")
    public ModelAndView articleList(@RequestParam(value = "page", required = false) String page, HttpServletRequest request) {
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
        /*for (Article article : articleList) {
            System.err.println(article.toString());
        }*/
        mv.addObject("articleList", articleList);
        System.err.println("文章总数:" + articleService.getArticleCount(listMap));
        //System.err.println("page:"+PageUtil.pageInfo(request.getContextPath()+"/article",articleService.articleCount(listMap),Integer.parseInt(page),7));
        mv.addObject("pageCode", PageUtil.pageInfo(request.getContextPath() + "/article", articleService.getArticleCount(listMap), Integer.parseInt(page), pageList.getlistNum()));
        mv.setViewName("article/article_index");
        return mv;
    }
    /**
     * 获得编辑的文章内容与添加新的文章
     * @param article
     * @return
     */
    @RequestMapping(value = "editorContent", method = RequestMethod.POST)
    public ModelAndView articleContent(@RequestBody Article article) {
        System.err.println("文章标题\n"+article.getArticleTitle());
        System.err.println("MD文本:\n"+article.getArticleContent());
        article.setArticleCreateTime(DateUtil.getCurrentDateString());
        System.err.println(article.toString());
        articleService.insertArticle(article);
        return null;
    }

    @RequestMapping("/articleDetail/{id}")
    public ModelAndView articleDetail(@PathVariable("id")Integer id){

        ModelAndView mv = new ModelAndView();
        Article article  = articleService.getArticleById(id);
        mv.addObject("article",article);
        System.err.println(article.toString());
        mv.setViewName("article/article_detail");
        return mv;

    }

    /**
     * 返回文章编辑界面
     *
     * @return editor article
     */
    @RequestMapping("/writeArticle")
    public ModelAndView writeArticle() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/admin");
        return mv;
    }

}
