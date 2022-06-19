package com.baosi.ssm.service.impl;

import com.baosi.ssm.dao.IProductDao;
import com.baosi.ssm.domain.Product;
import com.baosi.ssm.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class ProductServiceImpl implements IProductService {

    @Autowired(required = false)
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int page, int size) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return productDao.findAll();
    }

    @Override
    public List<Product> findAllPre() throws Exception {
        return productDao.findAllPre();
    }

    @Override
    public List<Product> findAllPre_en() throws Exception {
        return productDao.findAllPre_en();
    }
    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void deleteProductById(int id) {
        productDao.deleteProductById(id);
    }

    @Override
    public Product findProFor(int id) {
        return productDao.findProFor(id);
    }
    @Override
    public Product findProFor_en(int id) {
        return productDao.findProFor_en(id);
    }

    @Override
    public Product findProBack(int id) {
        return productDao.findProBack(id);
    }

    @Override
    public Product findProBack_en(int id) {
        return productDao.findProBack_en(id);
    }
}
