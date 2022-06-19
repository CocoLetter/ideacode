package com.baosi.ssm.dao;

import com.baosi.ssm.domain.Honor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IHonorDao {

    @Select("select * from honor")
    List<Honor> findAll();

    @Insert("insert into honor(url) value(#{url})")
    void save(Honor honor);

    @Select("select * from honor where id = #{id}")
    Honor findById(int id);

    @Delete("delete from honor where id = #{id}")
    void deleteImageById(int id);
}
