package com.hly.sirius.controller;

import com.hly.sirius.domain.Article;
import com.hly.sirius.service.ArticleService;
import com.hly.sirius.service.CategoryService;
import com.hly.sirius.util.ArticleUtil;
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
 * @date :2018/11/20
 */
@Controller
@RequestMapping("/admin")
public class AdminManageArticlesController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    /**
     * 得到所有文章
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/articleManage")
    public ModelAndView getArticles(@RequestParam(value = "page", required = false) String page, HttpServletRequest request){

        //查询文章的参数
        Map<String, Object> articleMap = new HashMap<String, Object>();
        //得到文章数目，分类，年月分类信息
        ModelAndView modelAndView = ArticleUtil.getArticlesList(articleMap,page,request.getContextPath() + "/admin/articleManage",articleService,categoryService);
        //所有文章信息
        List<Article> articleList = articleService.getArticleList(articleMap);
        modelAndView.addObject("articleList", articleList);
        modelAndView.setViewName("admin/admin_manage_articles");
        return modelAndView;
    }


    /**
     * 编辑更新文章
     * @param id
     * @return
     */
    @RequestMapping("/editArticle/{id}")
    public String putArticleEdit(@PathVariable("id") Integer id){

        return "redirect:/articleDetail/'"+id;
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteArticle/{id}")
    public String deleteArticle(@PathVariable("id") Integer id){

        try {
            articleService.deleteArticleAndCategoryById(id);
            articleService.deleteArticleById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/admin/articleManage";
    }

}
