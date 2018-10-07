package com.hly.sirius.controller;


import com.hly.sirius.domain.Article;
import com.hly.sirius.service.ArticleService;
import com.hly.sirius.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :github.com/SiriusHly
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
     * @return
     */
    @RequestMapping("/article")
    public ModelAndView articleList(@RequestParam(value = "page" ,required = false)String page, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(page==null)
            page="1";
        //Page pageList = new Page(Integer.parseInt(page),7);
        Map<String,Object> listMap = new HashMap<String, Object>();
        //开始记录数
        //listMap.put("start",pageList.getStart());
        //一页总记录数
        listMap.put("size",7);
        //当前页数
        listMap.put("page",Integer.parseInt(page));
        List<Article> articleList = articleService.articleList(listMap);
        for(Article article:articleList){
            System.err.println(article.toString());
        }
        mv.addObject("articleList",articleList);
        System.err.println("文章总数:"+articleService.articleCount(listMap));
        mv.addObject("pageCode", PageUtil.pageInfo(request.getContextPath()+"/article",articleService.articleCount(listMap),Integer.parseInt(page),7));
        mv.setViewName("jsp/article/articleList");
        return mv;
    }

}
