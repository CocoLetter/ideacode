package com.baosi.ssm.dao;

import com.baosi.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IProductDao {

    //查询所有产品信息
    @Select("select * from product order by id desc")
    List<Product> findAll() throws Exception;

    //前端查询所有中文产品
    @Select("select * from product where languages = 0 order by id")
    List<Product> findAllPre() throws Exception;

    //前端查询所有英文产品
    @Select("select * from product where languages = 1 order by id")
    List<Product> findAllPre_en() throws Exception;

    @Insert("insert into product(productname,productprice,productdesc,productchar,url,languages,prodparamurl) " +
            "values(#{productName},#{productPrice},#{productDesc},#{productChar},#{url},#{languages},#{prodParamUrl})")
    void save(Product product);

    @Update("update product set productname=#{productName},productprice=#{productPrice},productdesc=#{productDesc},productchar=#{productChar}," +
            "url=#{url},languages=#{languages},prodparamurl=#{prodParamUrl} where id = #{id}")
    void update(Product product);

    @Select("select * from product where id = #{id}")
    Product findById(int id);

    @Delete("delete from product where id = #{id}")
    void deleteProductById(int id);

    @Select("select * from product where id < #{id} and languages = 0 order by id desc limit 1")
    Product findProFor(int id);

    @Select("select * from product where id < #{id} and languages = 1 order by id desc limit 1")
    Product findProFor_en(int id);

    @Select("select * from product where id > #{id} and languages = 0 order by id asc limit 1")
    Product findProBack(int id);

    @Select("select * from product where id > #{id} and languages = 1 order by id asc limit 1")
    Product findProBack_en(int id);

}
