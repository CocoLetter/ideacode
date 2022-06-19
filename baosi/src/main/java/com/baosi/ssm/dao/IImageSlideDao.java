package com.baosi.ssm.dao;
import com.baosi.ssm.domain.ImageSlide;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IImageSlideDao {

    @Select("select * from imageSlide")
    List<ImageSlide> findAll();

    @Insert("insert into imageSlide(imageSlideName,imageStatus,url) values(#{imageSlideName},#{imageStatus},#{url})")
    void save(ImageSlide imageSlide);

    @Select("select * from imageSlide where id = #{id}")
    ImageSlide findById(int id);

    @Delete("delete from imageSlide where id = #{id}")
    void deleteImageById(int id);

    @Update("update imageSlide set imageStatus = 1 where id = #{id}")
    void unlockById(int id);

    @Update("update imageSlide set imageStatus = 0 where id = #{id}")
    void lockById(int id);
}
