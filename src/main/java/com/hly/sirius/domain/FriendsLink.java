package com.hly.sirius.domain;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/16
 */
public class FriendsLink {
    private String friendName;
    private String friendBlog;
    private String friendGithub;
    private String friendQQ;
    private String friendUnit;

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendBlog() {
        return friendBlog;
    }

    public void setFriendBlog(String friendBlog) {
        this.friendBlog = friendBlog;
    }

    public String getFriendGithub() {
        return friendGithub;
    }

    public void setFriendGithub(String friendGithub) {
        this.friendGithub = friendGithub;
    }

    public String getFriendQQ() {
        return friendQQ;
    }

    public void setFriendQQ(String friendQQ) {
        this.friendQQ = friendQQ;
    }

    public String getFriendUnit() {
        return friendUnit;
    }

    public void setFriendUnit(String friendUnit) {
        this.friendUnit = friendUnit;
    }

    @Override
    public String toString() {
        return "FriendsLink{" +
                "friendName='" + friendName + '\'' +
                ", friendBlog='" + friendBlog + '\'' +
                ", friendGithub='" + friendGithub + '\'' +
                ", friendQQ='" + friendQQ + '\'' +
                ", friendUnit='" + friendUnit + '\'' +
                '}';
    }
}
