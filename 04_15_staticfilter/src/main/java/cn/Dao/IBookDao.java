package cn.Dao;

import cn.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookDao {


    @Select("select * from t_book")
    public List<Book> findAll();



    @Select("select * from t_book where category = #{category}")
    public List<Book> findByCategory(int category);

}
