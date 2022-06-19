package dao;

import mysqldaodomain.items;

import java.util.List;

public interface mysqldao {

    public List<items> findall() throws Exception;


}
