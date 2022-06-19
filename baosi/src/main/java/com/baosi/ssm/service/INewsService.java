package com.baosi.ssm.service;

import com.baosi.ssm.domain.News;

import java.util.List;

public interface INewsService {

    List<News> findAll(int page, int size);

    void save(News news);

    void updateNews(News news);

    void deleteNewsById(int id);

    News findById(int id);

    List<News> findCorNews(int page, int size);
    List<News> findCorNews_en(int page, int size);


    List<News> findCorNews();
    List<News> findCorNews_en();


    List<News> findIndNews(int page, int size);
    List<News> findIndNews_en(int page, int size);

    List<News> findIndNews();
    List<News> findIndNews_en();


    News findCorFor(int id);
    News findCorFor_en(int id);

    News findIndFor(int id);
    News findIndFor_en(int id);

    News findCorBack(int id);
    News findCorBack_en(int id);

    News findIndBack(int id);
    News findIndBack_en(int id);
}

