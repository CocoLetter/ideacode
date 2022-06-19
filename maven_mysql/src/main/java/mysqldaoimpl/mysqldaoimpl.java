package mysqldaoimpl;
import dao.mysqldao;
import mysqldaodomain.items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class mysqldaoimpl implements mysqldao {
    public List<items> findall() throws Exception {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<items> list = new ArrayList<items>();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///maven?characterEncoding=utf8&amp&&useSSL=false&&serverTimezone=UTC", "root", "root");
            ps = connection.prepareStatement("select * from maven");
            rs = ps.executeQuery();
            while (rs.next()) {
                items item = new items();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                list.add(item);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(rs!=null){
                rs.close();
            }
            if(rs!=null){
                ps.close();
            }
            if(rs!=null){
                connection.close();
            }

        }

        return list;

    }
}
