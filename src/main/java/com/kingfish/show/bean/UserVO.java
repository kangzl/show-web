package com.kingfish.show.bean;

import org.springframework.util.StringUtils;

/**
 * Created by kingfish on 2017/7/19.
 */
public class UserVO {

    private static final String DEFAULT_HEADER_PIC = "images/default/2.jpg";

    private long id;
    private String userName;
    private String headerPicUrl;
    private String sex;


    public UserVO(long id, String userName, String headerPicUrl) {
        this.id = id;
        this.userName = userName;
        this.headerPicUrl = headerPicUrl;
    }

    public UserVO(String userName, String headerPicUrl) {
        this.userName = userName;
        this.headerPicUrl = headerPicUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeaderPicUrl() {
        if (StringUtils.isEmpty(headerPicUrl)) {
            return DEFAULT_HEADER_PIC;
        }
        return headerPicUrl;
    }

    public void setHeaderPicUrl(String headerPicUrl) {
        this.headerPicUrl = headerPicUrl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
