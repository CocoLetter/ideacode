package com.baosi.ssm.controller.front;

import com.baosi.ssm.domain.ImageSlide;
import com.baosi.ssm.domain.News;
import com.baosi.ssm.service.IImageSlideService;
import com.baosi.ssm.service.INewsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/news-pre")
public class PreNewsController {

    @Autowired
    private IImageSlideService imageSlideService;

    @Autowired
    private INewsService newsService;

    //查询公司新闻
    @RequestMapping("/findCorNews")
    public ModelAndView findCorNews(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                    @RequestParam(name = "size", required = true, defaultValue = "2") int size,
                                    @RequestParam(value = "lang", defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        //查询轮播图片
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        List<News> CorNewsList = null;
        //查询公司新闻
        if (lang == 1) {
            CorNewsList = newsService.findCorNews_en(page, size);
        } else {
            CorNewsList = newsService.findCorNews(page, size);
        }
        PageInfo pageInfo = new PageInfo(CorNewsList);
        //将图片放入视图中
        mv.addObject("imageSlideList", imageSlideList);
        //将公司新闻放入视图中
        mv.addObject("pageInfo", pageInfo);
        //设置预览页面
        if (lang == 1) {
            mv.setViewName("/front/cornews_en");
        } else {
            mv.setViewName("/front/cornews");
        }
        return mv;
    }

    //查询行业新闻
    @RequestMapping("/findIndNews")
    public ModelAndView findIndNews(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                    @RequestParam(name = "size", required = true, defaultValue = "2") int size,
                                    @RequestParam(value = "lang", defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        //查询轮播图片
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        //查询行业新闻
        List<News> IndNewsList;
        //查询公司新闻
        if (lang == 1) {
            IndNewsList = newsService.findIndNews_en(page, size);
        } else {
            IndNewsList = newsService.findIndNews(page, size);
        }
        PageInfo pageInfo = new PageInfo(IndNewsList);
        //将图片放入视图中
        mv.addObject("imageSlideList", imageSlideList);
        //将行业新闻放入视图中
        mv.addObject("pageInfo", pageInfo);
        //设置预览页面
        if (lang == 1) {
            mv.setViewName("/front/indnews_en");
        } else
            mv.setViewName("/front/indnews");
        return mv;
    }

    //展示公司新闻
    @RequestMapping("/toCorNewsDetails")
    public ModelAndView findCorById(int id, @RequestParam(value = "lang", defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        //查询轮播图片
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        //根据id查询新闻
        News news = newsService.findById(id);
        News newsFor, newsBack;
        if (lang == 1) {
            //查询上一篇
            newsBack = newsService.findCorBack_en(id);
            //查询下一篇
            newsFor = newsService.findCorFor_en(id);
        } else {
            newsFor = newsService.findCorFor(id);
            newsBack = newsService.findCorBack(id);
        }
        //将图片放入视图中
        mv.addObject("imageSlideList", imageSlideList);
        //将新闻内容放入视图中
        mv.addObject("news", news);
        //将上一篇和下一篇新闻放入视图中
        mv.addObject("newsBack", newsBack);
        mv.addObject("newsFor", newsFor);
        //设置预览页面
        if (lang == 1) {
            mv.setViewName("/front/cornews-detail_en");
        } else {
            mv.setViewName("/front/cornews-detail");
        }
        return mv;
    }

    //展示行业新闻
    @RequestMapping("/toIndNewsDetails")
    public ModelAndView findIndById(int id, @RequestParam(value = "lang", defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        //查询轮播图片
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        //根据id查询新闻
        News news = newsService.findById(id);

        News newsFor, newsBack;
        if (lang == 1) {
            //查询上一篇
            newsBack = newsService.findIndBack_en(id);
            //查询下一篇
            newsFor = newsService.findIndFor_en(id);
        } else {
            newsFor = newsService.findIndFor(id);
            newsBack = newsService.findIndBack(id);
        }
        //将图片放入视图中
        mv.addObject("imageSlideList", imageSlideList);
        //将新闻内容放入视图中
        mv.addObject("news", news);
        //将上一篇和下一篇新闻放入视图中
        mv.addObject("newsBack", newsBack);
        mv.addObject("newsFor", newsFor);
        //设置预览页面
        if (lang == 1) {
            mv.setViewName("/front/indnews-detail_en");
        } else {
            mv.setViewName("/front/indnews-detail");
        }
        return mv;
    }
}
