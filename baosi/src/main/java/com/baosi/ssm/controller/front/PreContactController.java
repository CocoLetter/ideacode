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
@RequestMapping("/contact")
public class PreContactController {

    @Autowired
    private IImageSlideService imageSlideService;

    //跳转联系方式
    @RequestMapping("/findContact")
    public ModelAndView findContact(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        //查询轮播图片
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        //将图片放入视图中
        mv.addObject("imageSlideList", imageSlideList);
        //设置预览页面
        if (lang == 1)
        {
            mv.setViewName("/front/contact_en");
        }else {
            mv.setViewName("/front/contact");
        }
        return mv;
    }

}
