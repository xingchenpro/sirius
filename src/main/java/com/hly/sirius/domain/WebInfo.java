package com.hly.sirius.domain;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/16
 */
public class WebInfo {

    private  String webName;
    private int webViewNum;
    private int webViewIPNum;

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public int getWebViewNum() {
        return webViewNum;
    }

    public void setWebViewNum(int webViewNum) {
        this.webViewNum = webViewNum;
    }

    public int getWebViewIPNum() {
        return webViewIPNum;
    }

    public void setWebViewIPNum(int webViewIPNum) {
        this.webViewIPNum = webViewIPNum;
    }

    @Override
    public String toString() {
        return "WebInfo{" +
                "webName='" + webName + '\'' +
                ", webViewNum=" + webViewNum +
                ", webViewIPNum=" + webViewIPNum +
                '}';
    }
}
