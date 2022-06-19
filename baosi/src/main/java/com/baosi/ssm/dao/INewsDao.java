package com.baosi.ssm.dao;

import com.baosi.ssm.domain.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface INewsDao {

    @Select("select * from news order by id desc")
    List<News> findAll();

    @Insert("insert into news(title,keywords,newsType,newsContent,url,languages)" +
            "values(#{title},#{keywords},#{newsType},#{newsContent},#{url},#{languages})")
    void save(News news);

    @Update("update news set title=#{title},keywords=#{keywords},newsType=#{newsType}," +
            "newsContent=#{newsContent},url=#{url},languages=#{languages} where id=#{id}")
    void update(News news);

    @Delete("delete from news where id = #{id}")
    void deleteNewsById(int id);

    @Select("select * from news where id = #{id}")
    News findById(int id);

    //    查公司新闻:中文
    @Select("select * from news where newsType = 0 and languages = 0 order by id desc")
    List<News> findCorNews();

    // 英文
    @Select("select * from news where newsType = 0 and languages = 1 order by id desc")
    List<News> findCorNews_en();

    //查行业新闻:中
    @Select("select * from news where newsType = 1 and languages = 0 order by id desc")
    List<News> findIndNews();

    //英文
    @Select("select * from news where newsType = 1 and languages = 1 order by id desc")
    List<News> findIndNews_en();

    //公司新闻，上一篇
    @Select("select * from news where id > #{id} and newsType = 0 and languages = 0 order by id limit 1")
    News findCorBack(int id);

    @Select("select * from news where id > #{id} and newsType = 0 and languages = 1 order by id limit 1")
    News findCorBack_en(int id);

    //公司新闻，下一篇
    @Select("select * from news where id < #{id} and newsType = 0 and languages = 0 order by id desc limit 1")
    News findCorFor(int id);

    @Select("select * from news where id < #{id} and newsType = 0 and languages = 1 order by id desc limit 1")
    News findCorFor_en(int id);

    //行业新闻，上一篇
    @Select("select * from news where id > #{id} and newsType = 1 and languages = 0 order by id limit 1")
    News findIndBack(int id);

    @Select("select * from news where id > #{id} and newsType = 1 and languages = 1 order by id limit 1")
    News findIndBack_en(int id);

    //行业新闻，下一篇
    @Select("select * from news where id < #{id} and newsType = 1 and languages = 0 order by id desc limit 1")
    News findIndFor(int id);

    @Select("select * from news where id < #{id} and newsType = 1 and languages = 1 order by id desc limit 1")
    News findIndFor_en(int id);


}
