package cn.Service.Impl;

import cn.Dao.IBookDao;
import cn.Service.IBookService;
import cn.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("bookService")
public class BookService implements IBookService {

    @Autowired
    private IBookDao bookDao;

    public BookService(){
        System.out.println("bookService初始化了...");
        System.out.println(this);
    }
    public BookService(String str){
        System.out.println("bookService被"+str+"初始化了");
    }


    public List<Book> findAll(){
        System.out.println("findAll");
        List<Book> all = bookDao.findAll();
        System.out.println("findAll执行了");
        return all;
    }

    public List<Book> findByCategory(int category){

        return bookDao.findByCategory(category);

    }


}
