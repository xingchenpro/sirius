package com.hly.sirius.controller;


import com.hly.sirius.domain.Article;
import com.hly.sirius.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


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
        articleService.updateArticleViewCount(id);
        Article article  = articleService.getArticleById(id);
        Article preArticle = articleService.getPreArticle(id);
        Article nextArticle = articleService.getNextArticle(id);
        //System.err.println(article.getArticleTitle()+" "+preArticle.toString()+" "+nextArticle.toString());
        mv.addObject("article",article);
        if(preArticle!=null)
            mv.addObject("preArticle",preArticle);
        if(nextArticle!=null)
            mv.addObject("nextArticle",nextArticle);
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
