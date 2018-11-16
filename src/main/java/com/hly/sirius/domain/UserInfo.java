package com.hly.sirius.domain;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/16
 */
public class UserInfo {

    //9属性
    private String username;
    private String userNickName;
    private String userEmail;
    private String userBlog;
    private String userUnit;
    private String userQQ;
    private String userWeChat;
    private String userWisdom;
    private String userProfile;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBlog() {
        return userBlog;
    }

    public void setUserBlog(String userBlog) {
        this.userBlog = userBlog;
    }

    public String getUserUnit() {
        return userUnit;
    }

    public void setUserUnit(String userUnit) {
        this.userUnit = userUnit;
    }

    public String getUserQQ() {
        return userQQ;
    }

    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }

    public String getUserWeChat() {
        return userWeChat;
    }

    public void setUserWeChat(String userWeChat) {
        this.userWeChat = userWeChat;
    }

    public String getUserWisdom() {
        return userWisdom;
    }

    public void setUserWisdom(String userWisdom) {
        this.userWisdom = userWisdom;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBlog='" + userBlog + '\'' +
                ", userUnit='" + userUnit + '\'' +
                ", userQQ='" + userQQ + '\'' +
                ", userWeChat='" + userWeChat + '\'' +
                ", userWisdom='" + userWisdom + '\'' +
                ", userProfile='" + userProfile + '\'' +
                '}';
    }
}
