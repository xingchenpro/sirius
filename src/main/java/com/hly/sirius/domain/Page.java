package com.hly.sirius.domain;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/11
 */
public class Page {
    private int currentPage;
    private int listNum;
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

    /*当前页数减1乘项数*/
    public int getStart() {
        return (currentPage-1)*listNum;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
