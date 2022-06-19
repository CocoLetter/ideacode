package com.baosi.ssm.controller.front;

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
@RequestMapping("/business-pre")

public class PreBusinessController {


    @Autowired
    private IImageSlideService imageSlideService;
    @Autowired
    private IHonorService honorService;

    //工程服务
    @RequestMapping("/findEngineeringService")
    public ModelAndView findEngineeringService(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        mv.addObject("imageSlideList",imageSlideList);
        if (lang == 1){
            mv.setViewName("/front/engineeringService_en");
        }else {
            mv.setViewName("/front/engineeringService");
        }
        return mv;
    }

    //设备销售
    @RequestMapping("/findSale")
    public ModelAndView findSale(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        mv.addObject("imageSlideList",imageSlideList);
        if (lang == 1){
            mv.setViewName("/front/sale_en");
        }else {
            mv.setViewName("/front/sale");
        }
        return mv;
    }

    //设备租赁
    @RequestMapping("/findRent")
    public ModelAndView findRent(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        mv.addObject("imageSlideList",imageSlideList);
        if (lang == 1){
            mv.setViewName("/front/rent_en");
        }else {
            mv.setViewName("/front/rent");
        }
        return mv;
    }

    //rent1
    @RequestMapping("/findRent1")
    public ModelAndView findRent1(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        mv.addObject("imageSlideList",imageSlideList);
        if (lang == 1){
            mv.setViewName("/front/rent1_en");
        }else {
            mv.setViewName("/front/rent1");
        }
        return mv;
    }

    //rent2
    @RequestMapping("/findRent2")
    public ModelAndView findRent2(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        mv.addObject("imageSlideList",imageSlideList);
        if (lang == 1){
            mv.setViewName("/front/rent2_en");
        }else {
            mv.setViewName("/front/rent2");
        }
        return mv;
    }

    //rent3
    @RequestMapping("/findRent3")
    public ModelAndView findRent3(@RequestParam(value = "lang",defaultValue = "0") int lang) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        mv.addObject("imageSlideList",imageSlideList);
        if (lang == 1){
            mv.setViewName("/front/rent3_en");
        }else {
            mv.setViewName("/front/rent3");
        }
        return mv;
    }


}
