package com;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;


public class JSoupTest {
    public static void main(String[] args) throws IOException {
        String path= JSoupTest.class.getClassLoader().getResource("book.xml").getPath();
        System.out.println(path);
        Document document = Jsoup.parse(new File(path),"utf-8");
        //获取元素对象
        Elements document2=document.select("书[number='1234']>售价");
        System.out.println(document2);


//
//        Elements elements =document.getElementsByTag("书名");
//        System.out.println(elements.size());
//        Element element=elements.get(0);
//
//        String name=element.text();
//        System.out.println(name);

    }
}















