package com.kingfish.show.bean;

import java.util.List;

/**
 * Created by kingfish on 2017/7/14.
 */
public class ShowVO {

    private boolean success;
    private String message;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        private long id;//showid
        private String content;//content
        //private String image;
        private String preview;
        private boolean isOutside;
        private UserVO user;
        private List<UserVO> userLikeLately;//最近点赞的用户列表 最多三个

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public boolean isOutside() {
            return isOutside;
        }

        public void setOutside(boolean outside) {
            isOutside = outside;
        }

        public UserVO getUser() {
            return user;
        }

        public void setUser(UserVO user) {
            this.user = user;
        }

        public List<UserVO> getUserLikeLately() {
            return userLikeLately;
        }

        public void setUserLikeLately(List<UserVO> userLikeLately) {
            this.userLikeLately = userLikeLately;
        }
    }
}
