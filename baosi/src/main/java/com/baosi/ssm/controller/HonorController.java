package com.baosi.ssm.controller;

import com.baosi.ssm.domain.Honor;
import com.baosi.ssm.domain.HonorResult;
import com.baosi.ssm.service.IHonorService;
import com.baosi.ssm.utils.ImageUtils;
import com.baosi.ssm.utils.String2IntegerUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/honor")

public class HonorController {

    @Autowired
    private IHonorService honorService;

    //查找所有业绩图片
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        ModelAndView mv = new ModelAndView();
        List<Honor> honorList = honorService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(honorList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("honor-page-list");
        return mv;
    }

    //新建业绩图片
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String save(Honor honor, HttpServletRequest request, MultipartFile pictureFile) {
        // 得到上传图片的地址
        String imgPath;
        try {
            //ImageUtils为之前添加的工具类
            imgPath = ImageUtils.upload(request, pictureFile);
            if (imgPath != null) {
                // 将上传图片的地址封装到实体类
                honor.setUrl(imgPath);
                System.out.println("-----------------图片上传成功！");
            } else {
                System.out.println("-----------------图片上传失败！");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("----------------图片上传失败！");
        }
        //将数据提交到数据库（包含文件和普通表单数据）
        honorService.save(honor);
        return "redirect:findAll.do";
    }

    //删除业绩图片
    @RequestMapping(path = "/delImage", method = RequestMethod.POST)
    public @ResponseBody
    HonorResult deleteImageById(@RequestParam("delItems") String items, HttpServletRequest request) {
        HonorResult result = new HonorResult();
        String imgPath;
        String imgUrl;
        //将字符串分割成数组
        String[] str = items.split(",");
        //调用方法实现字符串数组到int数组的转换
        int[] arr = String2IntegerUtils.String2Int(str);
        String path = request.getSession().getServletContext().getRealPath("/");
        for (int id : arr) {
            //获取要上传到的目标文件目录
            imgUrl = honorService.findById(id).getUrl();
            imgPath = path + imgUrl;
            //将本地文件夹中的文件删除
            try {
                //创建一个file对象
                File file = new File(imgPath);
                try {
                    if (file.exists()) {
                        //删除文件
                        file.delete();
                        //数据库中删除文件名
                        honorService.deleteImageById(id);
                        result.setSuccess(true);
                    } else {
                        System.out.println("要删除的文件不存在！");//模拟日志打印
                        honorService.deleteImageById(id);//直接删除名称
                        result.setSuccess(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                result.setSuccess(false);
                e.printStackTrace();
            }
        }
        return result;
    }
}
