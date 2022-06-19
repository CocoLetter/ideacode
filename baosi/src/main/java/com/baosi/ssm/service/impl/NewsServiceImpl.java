package com.baosi.ssm.service.impl;

import com.baosi.ssm.dao.INewsDao;
import com.baosi.ssm.domain.News;
import com.baosi.ssm.service.INewsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class NewsServiceImpl implements INewsService {

    @Autowired(required = false)
    private INewsDao newsDao;

    @Override
    public List<News> findAll(int page, int size) {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return newsDao.findAll();
    }

    @Override
    public void save(News news) {
        newsDao.save(news);
    }

    @Override
    public void updateNews(News news) {
        newsDao.update(news);
    }

    @Override
    public void deleteNewsById(int id) {
        newsDao.deleteNewsById(id);
    }

    @Override
    public News findById(int id) {
        return newsDao.findById(id);
    }

    @Override
    public List<News> findCorNews(int page, int size) {
        PageHelper.startPage(page, size);
        return newsDao.findCorNews();
    }

    @Override
    public List<News> findCorNews_en(int page, int size) {
        PageHelper.startPage(page, size);
        return newsDao.findCorNews_en();
    }

    @Override
    public List<News> findIndNews(int page, int size) {
        PageHelper.startPage(page, size);
        return newsDao.findIndNews();
    }

    @Override
    public List<News> findIndNews_en(int page, int size) {
        PageHelper.startPage(page, size);
        return newsDao.findIndNews_en();
    }

    @Override
    public List<News> findCorNews() {
        return newsDao.findCorNews();
    }

    @Override
    public List<News> findCorNews_en() {
        return newsDao.findCorNews_en();
    }

    @Override
    public List<News> findIndNews() {
        return newsDao.findIndNews();
    }

    @Override
    public List<News> findIndNews_en() {
        return newsDao.findIndNews_en();
    }

    @Override
    public News findCorFor(int id) { return newsDao.findCorFor(id);
    }

    @Override
    public News findCorFor_en(int id) {
        return newsDao.findCorFor_en(id);
    }

    @Override
    public News findCorBack(int id) {
        return newsDao.findCorBack(id);
    }

    @Override
    public News findCorBack_en(int id) {
        return newsDao.findCorBack_en(id);
    }

    @Override
    public News findIndFor(int id) {
        return newsDao.findIndFor(id);
    }

    @Override
    public News findIndFor_en(int id) {
        return newsDao.findIndFor_en(id);
    }

    @Override
    public News findIndBack(int id) {
        return newsDao.findIndBack(id);
    }

    @Override
    public News findIndBack_en(int id) {
        return newsDao.findIndBack_en(id);
    }
}
