package com.hly.sirius.util;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/12
 */
public class PageUtil {
     /*<li><a href="#">首页</a></li>
        <li><a href="#">上一页</a></li>
        <li><a class="active" href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">下一页</a></li>
        <li><a href="#">尾页</a></li>
*/
    /**
     *
     * @param url 目标地址url
     * @param articleCount 查询到的文章总数
     * @param currentPage 当前页
     * @param listCount 每一列文章列表数
     * @return
     */
    public static String pageInfo(String url,int articleCount,int currentPage,int listCount){
        int pageCount = articleCount%listCount==0?articleCount/listCount:articleCount/listCount+1;
        if(pageCount==0){
            return "没有相关文章";
        }else{
            StringBuffer pageCode = new StringBuffer();
            pageCode.append(" <li><a href='"+url+"?page=1"+"'>首页</a></li>");
            if(currentPage>1){
                pageCode.append("<li><a href='"+url+"?page="+(currentPage-1)+"'>上一页</a></li>");
            }
            else{
                pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
            }
            for(int i =currentPage-2;i<=currentPage+2;i++){
                    if(i<1||i>pageCount){
                        continue;
                    }
                    if(i==currentPage){
                        pageCode.append("<li><a class='active' href='"+url+"?page="+i+"'>"+i+"</a></li>");
                    }else{
                        pageCode.append("<li><a href='"+url+"?page="+i+"'>"+i+"</a></li>");
                    }
            }
            if(currentPage<pageCount){
                pageCode.append("<li><a href='"+url+"?page="+(currentPage+1)+"'>下一页</a></li>");
            }else{
                pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
            }
            pageCode.append("<li><a href='"+url+"?page="+pageCount+"'>尾页</a></li>");
            return pageCode.toString();
        }

    }


}
