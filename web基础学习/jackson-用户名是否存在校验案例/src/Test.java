import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException {
       /* Person p1=new Person();
        Person p2=new Person();
        Person p3=new Person();
        p1.setAge(24);
        p1.setGender("female");
        p1.setName("张三");
        p2.setAge(42);
        p2.setGender("male");
        p2.setName("李四");
        p3.setAge(45);
        p3.setGender("male");
        p3.setName("王五");

        List<Person> ps=new ArrayList<Person>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name","张三");
        map.put("gender","female");
        map.put("age",78);




        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(ps);


        String map1 = mapper.writeValueAsString(map);
        System.out.println(map1);
        System.out.println(json);//{"name":"张三","gender":"female","age":24}
//        mapper.writeValue(new File("C:\\Study\\a.text"),p);
*/


        Person p1=new Person();
        p1.setAge(24);
        p1.setGender("female");
        p1.setName("张三");
        p1.setBirthday(new Date());
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(p1);
        System.out.println(json);

    }
}
