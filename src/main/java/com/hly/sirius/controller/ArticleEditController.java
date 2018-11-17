package com.hly.sirius.controller;

import com.hly.sirius.domain.Article;
import com.hly.sirius.service.ArticleService;
import com.hly.sirius.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/17
 */
@Controller
public class ArticleEditController {

    @Autowired
    ArticleService articleService;

    /**
     * 获得编辑的文章内容与添加新的文章
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "articleWriting", method = RequestMethod.POST)
    public ModelAndView postArticle(@RequestBody Article article, HttpSession session) {
        article.setUsername((String) session.getAttribute("username"));
        article.setArticleCreateTime(DateUtil.getCurrentDateString());
        System.err.println("文章标题\n" + article.getArticleTitle());
        System.err.println("MD文本:\n" + article.getArticleContent());
        System.err.println(article.toString());
        articleService.insertArticle(article);
        return null;
    }

    /**
     * 保存文章图片
     *
     * @return
     */
    @RequestMapping("/articlePhotos")
    public void postArticlePhotos(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile file) throws IOException {
        try {
            System.out.println("开始上传");
            request.setCharacterEncoding("utf-8");
            /*这里返回格式是html/txt才能上传*/
            response.setHeader("Content-Type", "application/json");
            //获得web项目的全路径,SpringBoot的图片保存在C盘用户路径的/Temp中,我们改变设置保存当当前项目下
            //String upload = request.getSession().getServletContext().getRealPath("/resource/upload/");
            //获取跟目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) path = new File("");
            System.out.println("path:"+path.getAbsolutePath());

            File upload = new File(path.getAbsolutePath(),"static/images/upload/");
            if(!upload.exists()) upload.mkdirs();
            System.out.println("upload url:"+upload.getAbsolutePath());

            //Calendar.getInstance()是获取一个Calendar对象并可以进行时间的计算，时区的指定
            Calendar date = Calendar.getInstance();
            //获得日期路径,MONTH个值的初始值是0，因此我们要用它来表示正确的月份时就需要加1。
            File dateFile = new File(date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + (date.get(Calendar.DATE)));
            //获得文件最初的路径
            String originalFile = file.getOriginalFilename();
            //得到完整路径名
            File newFile = new File(upload + File.separator + dateFile + File.separator + originalFile);

            /*文件不存在就创建*/
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            file.transferTo(newFile);
            //System.out.println("/resources/upload/"+dateFile+File.separator+originalFile);
            System.out.println(dateFile + "/" + file.getOriginalFilename());
            /*JSON格式*/
            response.getWriter().write("{\"success\":1,\"message\":\"上传成功\",\"url\":\"/images/upload/" + dateFile.getPath().replace('\\','/') + "/" + file.getOriginalFilename() + "\"}");

        } catch (Exception e) {
            response.getWriter().write("{\"success\":0}");

        }
    }

}
