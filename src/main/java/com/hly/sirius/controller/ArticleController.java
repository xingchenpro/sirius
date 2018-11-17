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
import javax.servlet.http.HttpSession;
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
     * 根据文章id获得文章
     * @param id
     * @return
     */
    @RequestMapping("/articleDetail/{id}")
    public ModelAndView getArticleDetail(@PathVariable("id")Integer id){
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
    public ModelAndView getWriteArticle() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/admin");
        return mv;
    }
}
