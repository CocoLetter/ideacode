package cn.Service;

import cn.domain.Book;

import java.util.List;

public interface IBookService {

    public List<Book> findAll();

    public List<Book> findByCategory(int category);
}
