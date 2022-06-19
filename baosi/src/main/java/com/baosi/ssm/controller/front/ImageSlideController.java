package com.baosi.ssm.controller.front;

import com.baosi.ssm.domain.ImageSlide;
import com.baosi.ssm.domain.News;
import com.baosi.ssm.service.IImageSlideService;
import com.baosi.ssm.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/index")
public class ImageSlideController {

    @Autowired
    private IImageSlideService imageSlideService;

    @Autowired
    private INewsService newsService;

    //查询所有轮播图以及新闻
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "lang", defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        //查询轮播图片
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        List<News> CorNewsList,IndNewsList;
        if (lang==1){
            //查询企业新闻
            CorNewsList = newsService.findCorNews_en();
            //查询行业新闻
            IndNewsList = newsService.findIndNews_en();
        }
        else {
            //查询企业新闻
             CorNewsList = newsService.findCorNews();
            //查询行业新闻
             IndNewsList = newsService.findIndNews();
        }
        //将图片放入视图中
        mv.addObject("imageSlideList", imageSlideList);
        //将企业新闻放入视图中
        mv.addObject("CorNewsList", CorNewsList);
        //将行业新闻放入视图中
        mv.addObject("IndNewsList", IndNewsList);
        //设置预览页面
        if (lang == 1){
            mv.setViewName("front/index_en");
        }else {
            mv.setViewName("front/index");
        }
        return mv;
    }
}
