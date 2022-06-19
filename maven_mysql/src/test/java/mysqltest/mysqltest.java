package mysqltest;

import dao.mysqldao;
import mysqldaodomain.items;
import mysqldaoimpl.mysqldaoimpl;
import org.junit.Test;

import java.util.List;

public class mysqltest {
    @Test
    public void findall() throws Exception{
        mysqldao impl = new mysqldaoimpl();
        List<items> findall = impl.findall();
        for(items each:findall){
            System.out.println(each.getName());
        }


    }
}
