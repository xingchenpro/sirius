package com.hly.sirius.domain;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/11
 */
public class Page {
    //当前页
    private int currentPage;
    //每页记录
    private int listNum;
    //起始页
    private int start;

    public Page(int currentPage, int listNum) {
        this.currentPage = currentPage;
        this.listNum = listNum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getlistNum() {
        return listNum;
    }

    public void setlistNum(int listNum) {
        this.listNum = listNum;
    }

    /*当前页数减1乘项数：从第几条记录开始查询*/
    public int getStart() {
        return (currentPage-1)*listNum;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
