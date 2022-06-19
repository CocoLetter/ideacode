import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class jedistest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));

    }

    @Test
    public void test() throws InterruptedException {
        Jedis jedis=new Jedis();
        System.out.println("连接成功");
        jedis.setex("activecode",10,"hello");
        System.out.println("redis存储字段串为"+jedis.get("activecode"));
        Thread.sleep(12000);
        System.out.println("redis存储字段串为"+jedis.get("activecode"));
    }

    //hash
    @Test
    public void test1(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","female");
        String name=jedis.hget("user","name");
        System.out.println(name);
        Map<String,String> user = jedis.hgetAll("user");
        Set<String> keySet=user.keySet();
        for(String key:keySet){
            String value = user.get(key);
            System.out.println(key+":"+value);
        }

    }

    //list
    @Test
    public void test2(){
        Jedis jedis=new Jedis();
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

        List<String> mylist=jedis.lrange("mylist",0,-1);

        System.out.println(mylist);

        String element1 =jedis.lpop("mylist");
        System.out.println(element1);

        String element2 = jedis.rpop("mylist");
        System.out.println(element2);

        jedis.close();
    }

        /*
        [c, b, a, a, b, c]
        c
        c
        * */

        //set
    @Test
    public void test3(){
        Jedis jedis=new Jedis();
        jedis.sadd("myset","a","C++","java","name");
        jedis.sadd("myset","b","a","java");
//        jedis.sadd("myset","c");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        jedis.close();
    }


    //sortedset
    @Test
    public void test4(){
        Jedis jedis = new Jedis();
        jedis.zadd("mysortedset",3,"压索");
        jedis.zadd("mysortedset",1,"hello");
        jedis.zadd("mysortedset",8,"heihei");

        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);
    }


    //jedispool
    @Test
    public void test5(){
        //创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMinIdle(1);

        config.setMaxTotal(8);

        //1.创建连接池
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        //2.获取连接
        Jedis jedis=jedisPool.getResource();
        //3.使用
        jedis.set("hehe","haha");
        //4.关闭
        jedis.close();
    }


    @Test
    public void test6(){
        Jedis jedis= JedisPoolUtils.getJedis();
        //3.使用
        jedis.set("hehe","haha");
        //4.关闭
        System.out.println(jedis.get("hehe"));
        jedis.close();
    }


    @Test
    public void test7(){
        Jedis jedis= JedisPoolUtils.getJedis();
        //3.使用
        jedis.set("hehe","haha");
        //4.关闭
        System.out.println(jedis.get("hehe"));
        jedis.close();
    }
}
