package com.zsl.dto;

import com.zsl.entity.FriendMessage;

/**
 * Created by 蛮夷麟爷 on 2017-07-18.
 */

public class FriendMessageResult {

    private FriendMessage friendMessage; //朋友圈信息

    private String username; //用户名信息

    private String name; //昵称

    private String timeStr; //时间转换成字符串的

    private Integer maxPage; //最大页面

    private String userImage; //用户头像

    private Integer Size; //页面数量


    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
    public FriendMessage getFriendMessage() {
        return friendMessage;
    }

    public void setFriendMessage(FriendMessage friendMessage) {
        this.friendMessage = friendMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

    public Integer getSize() {
        return Size;
    }

    public void setSize(Integer size) {
        Size = size;
    }

}
