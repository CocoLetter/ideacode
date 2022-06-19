package com.baosi.ssm.domain;

import java.util.List;

public class NewsResult {

    private boolean success;
    private List<News> newsList;
    private News newsData;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public News getNewsData() {
        return newsData;
    }

    public void setNewsData(News newsData) {
        this.newsData = newsData;
    }
}
