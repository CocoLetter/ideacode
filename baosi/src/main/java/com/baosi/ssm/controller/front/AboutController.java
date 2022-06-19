package com.baosi.ssm.controller.front;

import com.baosi.ssm.domain.Honor;
import com.baosi.ssm.domain.ImageSlide;
import com.baosi.ssm.service.IHonorService;
import com.baosi.ssm.service.IImageSlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/about")

public class AboutController {

    @Autowired
    private IImageSlideService imageSlideService;

    @Autowired
    private IHonorService honorService;

    //查询所有轮播图片
    @RequestMapping("/findAbout")
    public ModelAndView findAbout(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        mv.addObject("imageSlideList",imageSlideList);
        if (lang == 1){
            mv.setViewName("/front/about_en");
        }else {
            mv.setViewName("/front/about");
        }
        return mv;
    }

    @RequestMapping("/findManage")
    public ModelAndView findManage(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        mv.addObject("imageSlideList",imageSlideList);
        if (lang == 1){
            mv.setViewName("/front/manage_en");
        }else {
            mv.setViewName("/front/manage");
        }
        return mv;
    }

    @RequestMapping("/findCulture")
    public ModelAndView findCulture(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        mv.addObject("imageSlideList",imageSlideList);
        if (lang == 1){
            mv.setViewName("/front/culture_en");
        }else {
            mv.setViewName("/front/culture");
        }
        return mv;
    }

    @RequestMapping("/findHonor")
    public ModelAndView findHonor(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        List<Honor> honorList = honorService.findAll();
        mv.addObject("imageSlideList",imageSlideList);
        mv.addObject("honorList",honorList);
        if (lang == 1){
            mv.setViewName("/front/honor_en");
        }else {
            mv.setViewName("/front/honor");
        }
        return mv;

    }
}
