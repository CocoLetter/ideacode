package com.baosi.ssm.domain;

public class ImageSlide {

    private Integer id;
    private String imageSlideName;
    private String url;
    private Integer imageStatus;
    private String imageStatusStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageSlideName() {
        return imageSlideName;
    }

    public void setImageSlideName(String imageSlideName) {
        this.imageSlideName = imageSlideName;
    }

    public Integer getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(Integer imageStatus) {
        this.imageStatus = imageStatus;
    }

    public String getImageStatusStr() {
        if (this.imageStatus != 0) {
            imageStatusStr = "开启";
        } else {
            imageStatusStr = "关闭";
        }
        return imageStatusStr;
    }

    public void setImageStatusStr(String imageStatusStr) {
        this.imageStatusStr = imageStatusStr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
