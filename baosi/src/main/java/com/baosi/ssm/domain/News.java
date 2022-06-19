package com.baosi.ssm.domain;

import com.baosi.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class News {

    private Integer id;
    private String title;
    private String keywords;
    private String newsContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private String releaseDateStr;
    private Integer newsType;
    private String newsTypeStr;
    private String url; //存储url进数据库
    private Integer languages;
    private String languagesStr;

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDateStr() {
        if (releaseDate != null) {
            releaseDateStr = DateUtils.date2String(releaseDate, "yyyy-MM-dd HH:mm:ss");
        }
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
    }

    public String getKeywords() {
        if (languages == 0) {
            if (keywords.length() > 70) {
                return keywords.substring(0, 70) + "...";
            } else {
                return keywords;
            }
        } else {
            if (keywords.length() > 140) {
                return keywords.substring(0, 140) + "...";
            } else {
                return keywords;
            }
        }
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public String getNewsTypeStr() {
        if (newsType == 0 && languages == 0) {
            newsTypeStr = "公司新闻";
        } else if (newsType == 1 && languages == 0){
            newsTypeStr = "行业新闻";
        } else if (newsType == 0 && languages == 1) {
            newsTypeStr = "Corporate news";
        } else {
            newsTypeStr = "Industry news";
        }
        return newsTypeStr;
    }

    public void setNewsTypeStr(String newsTypeStr) {
        this.newsTypeStr = newsTypeStr;
    }

    public Integer getLanguages() {
        return languages;
    }

    public void setLanguages(Integer languages) {
        this.languages = languages;
    }

    public String getLanguagesStr() {
        if (this.languages == 0) {
            languagesStr = "中文";
        } else {
            languagesStr = "English";
        }
        return languagesStr;
    }

    public void setLanguagesStr(String languagesStr) {
        this.languagesStr = languagesStr;
    }
}
