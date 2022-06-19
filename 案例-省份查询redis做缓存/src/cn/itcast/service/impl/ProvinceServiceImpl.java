package cn.itcast.service.impl;

import cn.itcast.dao.ProvinceDao;
import cn.itcast.dao.impl.ProvinceDaoImpl;
import cn.itcast.domain.Province;
import cn.itcast.service.ProvinceService;
import cn.itcast.util.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService{

    private ProvinceDao dao=new ProvinceDaoImpl();//问题

    @Override
    public List<Province> findAll(){
//        System.out.println("ProvinceServiceImpl");
        return dao.findAll();
    }

    public String findAllJson(){

        Jedis jedis= JedisPoolUtils.getJedis();

        String province_json=jedis.get("province");

        if(province_json==null||province_json.length()==0){
            System.out.println("redis中没有数据,查询数据库...");
            List<Province> ps = dao.findAll();
            ObjectMapper mapper=new ObjectMapper();
            try {
                province_json=mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //将json数据存入redis
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
        }else{
            System.out.println("redis中有数据,查询缓存...");
        }
        return province_json;
    }

}
