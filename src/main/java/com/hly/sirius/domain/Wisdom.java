package com.hly.sirius.domain;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/16
 */
public class Wisdom {

    private int wisdomId;
    private String wisdomContent;
    private String wisdomAddTime;

    public int getWisdomId() {
        return wisdomId;
    }

    public void setWisdomId(int wisdomId) {
        this.wisdomId = wisdomId;
    }

    public String getWisdomContent() {
        return wisdomContent;
    }

    public void setWisdomContent(String wisdomContent) {
        this.wisdomContent = wisdomContent;
    }

    public String getWisdomAddTime() {
        return wisdomAddTime;
    }

    public void setWisdomAddTime(String wisdomAddTime) {
        this.wisdomAddTime = wisdomAddTime;
    }

    @Override
    public String toString() {
        return "Wisdom{" +
                "wisdomId=" + wisdomId +
                ", wisdomContent='" + wisdomContent + '\'' +
                ", wisdomAddTime='" + wisdomAddTime + '\'' +
                '}';
    }
}
