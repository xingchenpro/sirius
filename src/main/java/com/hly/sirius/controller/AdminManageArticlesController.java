package com.hly.sirius.controller;

import com.hly.sirius.domain.Article;
import com.hly.sirius.domain.ArticleCategories;
import com.hly.sirius.domain.Category;
import com.hly.sirius.service.ArticleService;
import com.hly.sirius.service.CategoryService;
import com.hly.sirius.util.ArticleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/admin/manage")
public class AdminManageArticlesController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    /**
     * 得到所有文章
     *
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/article")
    public ModelAndView getArticles(@RequestParam(value = "page", required = false) String page, HttpServletRequest request) {
        //查询文章的参数
        Map<String, Object> articleMap = new HashMap<String, Object>();
        //得到文章数目，分类，年月分类信息
        ModelAndView modelAndView = ArticleUtil.getArticlesList(articleMap, page, 7,request.getContextPath() + "/admin/manage/article", articleService, categoryService);
        //所有文章信息
        List<Article> articleList = articleService.getArticleList(articleMap);
        modelAndView.addObject("articleList", articleList);
        modelAndView.setViewName("/admin/admin_manage_articles");
        return modelAndView;
    }


    /**
     * 编辑更新文章
     *
     * @param id
     * @return
     */
    @RequestMapping("/edit/article/{id}")
    public ModelAndView putArticleEdit(@PathVariable("id") Integer id) {

        ModelAndView modelAndView = new ModelAndView();
        //获得文章
        Article article = articleService.getArticleById(id);
        //获得该文章所对应的分类
        List<Category> articleCategoryList = categoryService.getCategoriesByArticleId(id);
        //获得所有的分类
        List<Category> categories = categoryService.getCategories();
        //为该文章的分类赋值
        for (int i = 0; i < categories.size(); i++) {
            for (int j = 0; j < articleCategoryList.size(); j++) {
                if (categories.get(i).getCategoryName().equals(articleCategoryList.get(j).getCategoryName()))
                    categories.get(i).setCategoryOrder(1);
            }
        }
        modelAndView.addObject("article", article);
        //modelAndView.addObject("articleCategoryList", articleCategoryList);
        modelAndView.addObject("categories", categories);
        System.err.println(categories);
        modelAndView.setViewName("/admin/admin_writing");
        return modelAndView;
    }

    /**
     * 更新文章
     *
     * @param articleCategories
     * @param
     * @return
     */
    @RequestMapping("/update/article")
    public ModelAndView putArticle(@RequestBody ArticleCategories articleCategories) {

        //得到文章
        Article article = articleCategories.getArticle();
        //获得文章类型
        List<String> categoryList = articleCategories.getCategoryList();

        Category category = null;
        Map<String, Object> articleCategoryMap = null;

        try {
            //更新文章
            articleService.updateArticle(article);
            //更新文章分类
            for (String categoryName : categoryList) {
                //如果数据库不存在该分类
                if (categoryService.getCategory(categoryName) == null) {
                    category = new Category();
                    category.setCategoryName(categoryName);
                    //添加新的分类
                    categoryService.addCategory(category);
                    //更新该分类的文章数目
                    categoryService.updateCategoryNum(categoryName);
                    //更新文章所对应的分类
                    articleCategoryMap = new HashMap<String, Object>();
                    articleCategoryMap.put("articleId", article.getArticleId());
                    articleCategoryMap.put("categoryId", category.getCategoryId());
                    articleService.addArticleCategory(articleCategoryMap);

                } else {
                    //更新文章所对应的分类
                    articleCategoryMap = new HashMap<String, Object>();
                    articleCategoryMap.put("articleId", article.getArticleId());
                    articleCategoryMap.put("categoryId", categoryService.getCategory(categoryName));
                    //不存在文章所对应的分类关系则删除
                    if (articleService.selectArticleCategory(articleCategoryMap).isEmpty())
                        articleService.addArticleCategory(articleCategoryMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println(article);
        System.err.println(categoryList);
        return null;
    }
    /**
     * 删除文章
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/article/{id}")
    public String deleteArticle(@PathVariable("id") Integer id) {

        try {
            articleService.deleteArticleAndCategoryById(id);
            articleService.deleteArticleById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/manage/article";
    }
}
