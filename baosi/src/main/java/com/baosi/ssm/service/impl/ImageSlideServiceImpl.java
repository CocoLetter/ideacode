package com.baosi.ssm.service.impl;

import com.baosi.ssm.dao.IImageSlideDao;
import com.baosi.ssm.domain.ImageSlide;
import com.baosi.ssm.service.IImageSlideService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ImageSlideServiceImpl implements IImageSlideService {

    @Autowired(required = false)
    private IImageSlideDao imageSlideDao;

    @Override
    public List<ImageSlide> findAll(int page, int size) {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return imageSlideDao.findAll();
    }

    @Override
    public void save(ImageSlide imageSlide) {
        imageSlideDao.save(imageSlide);
    }

    @Override
    public ImageSlide findById(int id) {
        return imageSlideDao.findById(id);
    }

    @Override
    public void deleteImageById(int id) {
        imageSlideDao.deleteImageById(id);
    }

    @Override
    public void unlockById(int[] arr) {
        for (int id : arr) {
            imageSlideDao.unlockById(id);
        }
    }

    @Override
    public void lockById(int[] arr) {
        for (int id : arr) {
            imageSlideDao.lockById(id);
        }
    }

    @Override
    public List<ImageSlide> findAll() {
        return imageSlideDao.findAll();
    }
}
