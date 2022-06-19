package com.baosi.ssm.controller;

import com.baosi.ssm.domain.ImageSlide;
import com.baosi.ssm.domain.ImageSlideResult;
import com.baosi.ssm.service.IImageSlideService;
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
@RequestMapping("/image")

public class ImageController {

    @Autowired
    private IImageSlideService imageSlideService;

    //查询所有轮播图 --分页
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) {
        ModelAndView mv = new ModelAndView();
        List<ImageSlide> imageSlideList = imageSlideService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(imageSlideList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("imageSlide-page-list");
        return mv;
    }

    //新建轮播图
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String save(ImageSlide imageSlide, HttpServletRequest request, MultipartFile pictureFile) {
        // 得到上传图片的地址
        String imgPath;
        try {
            //ImageUtils为之前添加的工具类
            imgPath = ImageUtils.upload(request, pictureFile);
            if (imgPath != null) {
                // 将上传图片的地址封装到实体类
                imageSlide.setUrl(imgPath);
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
        imageSlideService.save(imageSlide);
        return "redirect:findAll.do";
    }

    //根据id预览图片
    @RequestMapping(path = "/view")
    public @ResponseBody
    ImageSlideResult viewImageById(int id) {
        ImageSlideResult result = new ImageSlideResult();
        try {
            ImageSlide imageSlide = imageSlideService.findById(id);
            result.setSuccess(true);
            result.setImageSlide(imageSlide);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
//        System.out.println(result);
        return result;
    }

    //删除轮播图片
    @RequestMapping(path = "/delImage", method = RequestMethod.POST)
    public @ResponseBody
    ImageSlideResult deleteImageById(@RequestParam("delItems") String items, HttpServletRequest request) {
        ImageSlideResult result = new ImageSlideResult();
        String imgPath;
        String imgUrl;
        //将字符串分割成数组
        String[] str = items.split(",");
        //调用方法实现字符串数组到int数组的转换
        int[] arr = String2IntegerUtils.String2Int(str);
        String path = request.getSession().getServletContext().getRealPath("/");
        for (int id : arr) {
            //获取要上传到的目标文件目录
            imgUrl = imageSlideService.findById(id).getUrl();
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
                        imageSlideService.deleteImageById(id);
                        result.setSuccess(true);
                    } else {
                        System.out.println("要删除的文件不存在！");//模拟日志打印
                        imageSlideService.deleteImageById(id);//直接删除名称
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

    //根据id开启图片
    @RequestMapping(path = "/unlock", method = RequestMethod.POST)
    public @ResponseBody
    ImageSlideResult unlockById(@RequestParam("unlockItems") String items) {
        ImageSlideResult result = new ImageSlideResult();
        String[] str = items.split(",");
        int[] arr = String2IntegerUtils.String2Int(str);
        try {
            imageSlideService.unlockById(arr);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    //根据id关闭图片
    @RequestMapping(path = "/lock", method = RequestMethod.POST)
    public @ResponseBody
    ImageSlideResult lockById(@RequestParam("lockItems") String items) {
        ImageSlideResult result = new ImageSlideResult();
        String[] str = items.split(",");
        int[] arr = String2IntegerUtils.String2Int(str);
        try {
            imageSlideService.lockById(arr);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
}
