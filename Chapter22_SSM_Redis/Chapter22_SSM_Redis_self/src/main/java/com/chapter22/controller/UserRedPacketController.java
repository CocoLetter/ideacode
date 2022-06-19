package com.chapter22.controller;


import com.chapter22.pojo.UserRedPacket;
import com.chapter22.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

    @Autowired
    private UserRedPacketService userRedPacketService = null;


/*
    @RequestMapping("/grapRedPacket")
    public ModelAndView grapRedPacket(Long redPackageId ,Long userId,ModelAndView modelAndView) {

        int result=userRedPacketService.grapRedPacket(redPackageId,userId);
        modelAndView.setViewName("success");
        boolean flag = result > 0;
        modelAndView.addObject("success",true);
        modelAndView.addObject("message", flag ? "抢红包成功" : "抢红包失败");


        return modelAndView;
    }*/



    @RequestMapping("/grapRedPacket")
    @ResponseBody
    public Map<String, Object> grapRedPacket(Long redPacketId, Long userId) {
        // 抢红包
        int result = userRedPacketService.grapRedPacket(redPacketId, userId);
        Map<String, Object> retMap = new HashMap<String, Object>();
        boolean flag = result > 0;

        retMap.put("success", flag);
        retMap.put("message", flag ? "抢红包成功" : "抢红包失败");

        return retMap;
    }

    @RequestMapping("/grap")
    public ModelAndView grap(ModelAndView modelAndView) {
        modelAndView.setViewName("grap");
        return modelAndView;
    }


    @RequestMapping("/grapRedPacketByRedis")
    @ResponseBody
    public Map<String, Object> grapRedPacketByRedis(Long redPacketId, Long userId) {
        // 抢红包
        Long result = userRedPacketService.grapRedPacketByRedis(redPacketId, userId);
        Map<String, Object> retMap = new HashMap<String, Object>();
        boolean flag = result > 0;

        retMap.put("success", flag);
        retMap.put("message", flag ? "抢红包成功" : "抢红包失败");
        return retMap;
    }



}
