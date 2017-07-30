package com.kingfish.show.bean;

import org.springframework.util.StringUtils;

/**
 * Created by kingfish on 2017/7/19.
 */
public class UserVO extends BaseVO {

    private static final String DEFAULT_HEADER_PIC = "images/default/2.jpg";

    private long id;
    private String userName;
    private String headerPicUrl;
    private String sex;
    private String signature;
    private String mobilePhoneNumber;
    private String email;
    private Boolean hideNickName;


    public UserVO() {
    }

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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getHideNickName() {
        return hideNickName;
    }

    public void setHideNickName(Boolean hideNickName) {
        this.hideNickName = hideNickName;
    }
}
