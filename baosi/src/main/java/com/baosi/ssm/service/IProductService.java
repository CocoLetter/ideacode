package com.baosi.ssm.service;

import com.baosi.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll(int page, int size) throws Exception;

    List<Product> findAllPre() throws Exception;
    List<Product> findAllPre_en() throws Exception;

    void save(Product product) throws Exception;
    void update(Product product);
    Product findById(int id);

    void deleteProductById(int id);

    Product findProFor(int id);
    Product findProFor_en(int id);

    Product findProBack(int id);
    Product findProBack_en(int id);


}
