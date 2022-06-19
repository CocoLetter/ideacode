package com.baosi.ssm.service.impl;

import com.baosi.ssm.dao.IHonorDao;
import com.baosi.ssm.domain.Honor;
import com.baosi.ssm.service.IHonorService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HonorServiceImpl implements IHonorService {

    @Autowired(required = false)
    private IHonorDao honorDao;

    @Override
    public List<Honor> findAll(int page, int size) {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return honorDao.findAll();
    }

    @Override
    public List<Honor> findAll() {
        return honorDao.findAll();
    }

    @Override
    public void save(Honor honor) {
        honorDao.save(honor);
    }

    @Override
    public Honor findById(int id) {
        return honorDao.findById(id);
    }

    @Override
    public void deleteImageById(int id) {
        honorDao.deleteImageById(id);
    }
}
