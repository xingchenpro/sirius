package com.hly.sirius.domain;

import javax.persistence.*;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/4
 */
@Entity
public class Visitor {

    @Id
    //修改主键生成规则，不会自动生成hibernate_sequence表，https://www.imooc.com/qadetail/263950
    //根据底层数据库自动增长方式
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitorId;
    private String visitorName;
    private String visitorQQ;
    private String visitorTel;
    private String visitorEmail;
    private String visitorBlog;
    private String visitorGithub;
    private String visitorIP;

    public Visitor() {
    }

    public Visitor(int visitorId, String visitorName, String visitorQQ, String visitorTel, String visitorEmail, String visitorBlog, String visitorGithub, String visitorIP) {
        this.visitorId = visitorId;
        this.visitorName = visitorName;
        this.visitorQQ = visitorQQ;
        this.visitorTel = visitorTel;
        this.visitorEmail = visitorEmail;
        this.visitorBlog = visitorBlog;
        this.visitorGithub = visitorGithub;
        this.visitorIP = visitorIP;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorQQ() {
        return visitorQQ;
    }

    public void setVisitorQQ(String visitorQQ) {
        this.visitorQQ = visitorQQ;
    }

    public String getVisitorTel() {
        return visitorTel;
    }

    public void setVisitorTel(String visitorTel) {
        this.visitorTel = visitorTel;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    public String getVisitorBlog() {
        return visitorBlog;
    }

    public void setVisitorBlog(String visitorBlog) {
        this.visitorBlog = visitorBlog;
    }

    public String getVisitorGithub() {
        return visitorGithub;
    }

    public void setVisitorGithub(String visitorGithub) {
        this.visitorGithub = visitorGithub;
    }

    public String getVisitorIP() {
        return visitorIP;
    }

    public void setVisitorIP(String visitorIP) {
        this.visitorIP = visitorIP;
    }
}
