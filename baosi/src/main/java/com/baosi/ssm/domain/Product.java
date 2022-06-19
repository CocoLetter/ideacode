package com.baosi.ssm.domain;

//    产品信息
public class Product {

    private Integer id; // 主键
    private String productName; // 名称
    private String productPrice; // 产品价格
    private String productDesc; // 产品介绍
    private String productChar; //产品特点
    private String url; //产品照片
    private String prodParamUrl;//产品描述url
    private Integer languages;
    private String languagesStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductChar() {
        return productChar;
    }

    public void setProductChar(String productChar) {
        this.productChar = productChar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    public String getProdParamUrl() {
        return prodParamUrl;
    }
    public void setProdParamUrl(String prodParamUrl) {
        this.prodParamUrl = prodParamUrl;
    }
    public void setLanguagesStr(String languagesStr) {
        this.languagesStr = languagesStr;
    }
}

