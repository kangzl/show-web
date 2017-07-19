package com.kingfish.show.bean;

import java.util.List;

/**
 * Created by kingfish on 2017/7/14.
 */
public class ShowVO {

    /**
     * success : true
     * message : Retrieved pictures
     * data : [{"id":"1","title":"First image","url":"http://www.example.org/1","width":"200","height":"283","image":"img/image_1_big.jpg","preview":"img/image_1.jpg"},{"id":"2","title":"Second image","url":"http://www.example.org/2","width":"200","height":"300","image":"img/image_2_big.jpg","preview":"img/image_2.jpg"},{"id":"3","title":"Third image","url":"http://www.example.org/3","width":"200","height":"252","image":"img/image_3_big.jpg","preview":"img/image_3.jpg"},{"id":"4","title":"Fourth image","url":"http://www.example.org/4","width":"200","height":"158","image":"img/image_4_big.jpg","preview":"img/image_4.jpg"},{"id":"5","title":"Fifth image","url":"http://www.example.org/5","width":"200","height":"300","image":"img/image_5_big.jpg","preview":"img/image_5.jpg"},{"id":"6","title":"Sixth image","url":"http://www.example.org/6","width":"200","height":"297","image":"img/image_6_big.jpg","preview":"img/image_6.jpg"},{"id":"7","title":"Seventh image","url":"http://www.example.org/7","width":"200","height":"200","image":"img/image_7_big.jpg","preview":"img/image_7.jpg"},{"id":"8","title":"Eight image","url":"http://www.example.org/8","width":"200","height":"200","image":"img/image_8_big.jpg","preview":"img/image_8.jpg"},{"id":"9","title":"Ninth image","url":"http://www.example.org/9","width":"200","height":"398","image":"img/image_9_big.jpg","preview":"img/image_9.jpg"},{"id":"10","title":"Tenth image","url":"http://www.example.org/10","width":"200","height":"267","image":"img/image_10_big.jpg","preview":"img/image_10.jpg"}]
     */

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
        /**
         * id : 1
         * title : First image
         * url : http://www.example.org/1
         * width : 200
         * height : 283
         * image : img/image_1_big.jpg
         * preview : img/image_1.jpg
         */

        private String id;//showid
        private String content;//content
        private String url;
        private String width;
        private String height;
        private String image;
        private String preview;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }
    }
}
