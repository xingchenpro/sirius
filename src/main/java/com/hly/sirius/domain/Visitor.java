package com.hly.sirius.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/4
 */
//@Entity
public class Visitor {
    //11属性
    //@Id
    //修改主键生成规则，不会自动生成hibernate_sequence表，https://www.imooc.com/qadetail/263950
    //根据底层数据库自动增长方式
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitorId;
    private String visitorIP;
    private int visitorViewNum;
    private String visitorLastTime;

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public int getVisitorViewNum() {
        return visitorViewNum;
    }

    public void setVisitorViewNum(int visitorViewNum) {
        this.visitorViewNum = visitorViewNum;
    }

    public String getVisitorLastTime() {
        return visitorLastTime;
    }

    public void setVisitorLastTime(String visitorLastTime) {
        this.visitorLastTime = visitorLastTime;
    }

    public String getVisitorIP() {
        return visitorIP;
    }

    public void setVisitorIP(String visitorIP) {
        this.visitorIP = visitorIP;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorId=" + visitorId +
                ", visitorIP='" + visitorIP + '\'' +
                ", visitorViewNum=" + visitorViewNum +
                ", visitorLastTime='" + visitorLastTime + '\'' +
                '}';
    }
}
