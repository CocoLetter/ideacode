package com.baosi.ssm.domain;

import java.util.List;

public class ImageSlideResult {

    private boolean success;
    private List<ImageSlide> slideList;
    private ImageSlide imageSlide;

    public ImageSlide getImageSlide() {
        return imageSlide;
    }

    public void setImageSlide(ImageSlide imageSlide) {
        this.imageSlide = imageSlide;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<ImageSlide> getSlideList() {
        return slideList;
    }


    public void setSlideList(List<ImageSlide> slideList) {
        this.slideList = slideList;
    }

    @Override
    public String toString() {
        return "ImageSlideResult{" +
                "success=" + success +
                ", slideList=" + slideList +
                ", imageSlide=" + imageSlide +
                '}';
    }
}
