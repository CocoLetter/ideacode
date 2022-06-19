package com.baosi.ssm.controller;

import com.baosi.ssm.domain.News;
import com.baosi.ssm.domain.NewsResult;
import com.baosi.ssm.service.INewsService;
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
@RequestMapping("/news")

public class NewsController {

    @Autowired
    private INewsService newsService;

    //跳转到预览页面
    @RequestMapping("/toViewNews")
    public ModelAndView toPreviewNews(int id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.setViewName("news-view");
        return mv;
    }


    //跳转到新闻修改页面
    @RequestMapping("/toUpdateNews")
    public ModelAndView toUpdateNews(int id) {
        ModelAndView mv = new ModelAndView();
        //从数据库查信息
        News news = newsService.findById(id);
        //写入到编辑框
        mv.addObject("news", news);
        mv.setViewName("news-update");
        return mv;
    }

    //预览新闻
    @RequestMapping(path = "/view", method = RequestMethod.POST)
    public @ResponseBody
    NewsResult findById(@RequestParam("id") int id) {
        NewsResult result = new NewsResult();
        try {
            News news = newsService.findById(id);
            result.setNewsData(news);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    //删除新闻-->删除封面图片和ueditor缓存的内容图片
    @RequestMapping(path = "/delNews", method = RequestMethod.POST)
    public @ResponseBody
    NewsResult deleteImageById(@RequestParam("delItems") String items, HttpServletRequest request) {
        NewsResult result = new NewsResult();
        String imgPath;
        String imgUrl;
        //将字符串分割成数组
        String[] str = items.split(",");
        //调用方法实现字符串数组到int数组的转换
        int[] arr = String2IntegerUtils.String2Int(str);
        String path = request.getSession().getServletContext().getRealPath("/");
        for (int id : arr) {
            //获取要上传到的目标文件目录
            imgUrl = newsService.findById(id).getUrl();
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
                        newsService.deleteNewsById(id);
                        result.setSuccess(true);
                    } else {
                        System.out.println("要删除的文件不存在！");//模拟日志打印
                        newsService.deleteNewsById(id);//直接删除名称
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

    //添加新闻
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String save(News news, HttpServletRequest request, MultipartFile pictureFile) throws IOException {
        // 得到上传图片的地址
        String imgPath;
        try {
            //ImageUtils为之前添加的工具类
            imgPath = ImageUtils.upload(request, pictureFile);
            if (imgPath != null) {
                // 将上传图片的地址封装到实体类
                news.setUrl(imgPath);
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
        newsService.save(news);
        return "redirect:findAll.do";
    }


    //更新新闻
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(News news, HttpServletRequest request, MultipartFile pictureFile) throws IOException {
        // 得到上传图片的地址
        String imgPath;
        try {
            //ImageUtils为之前添加的工具类
            imgPath = ImageUtils.upload(request, pictureFile);
            if (imgPath != null) {
                // 将上传图片的地址封装到实体类
                news.setUrl(imgPath);
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
        newsService.updateNews(news);
        return "redirect:findAll.do";
    }

//    //添加新闻
//    @RequestMapping(path = "/save", method = RequestMethod.POST)
//    public @ResponseBody
//    NewsResult save(String title, String keywords, int newsType, String content) {
//        NewsResult result = new NewsResult();
//        News news = new News();
//        // 得到上传图片的地址
//        try {
//            news.setTitle(title);
//            news.setKeywords(keywords);
//            news.setNewsType(newsType);
//            news.setNewsContent(content);
//            newsService.save(news);
//            result.setSuccess(true);
//        } catch (Exception e) {
//            result.setSuccess(false);
//        }
//        return result;
//    }


    //查询所有新闻 --未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() {
//        ModelAndView mv = new ModelAndView();
//        List<News> newsList = newsService.findAll();
//        mv.addObject("newsList", newsList);
//        mv.setViewName("news-list");
//        return mv;
//    }

    //查询所有新闻 --分页
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        ModelAndView mv = new ModelAndView();
        List<News> newsList = newsService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(newsList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("news-page-list");
        return mv;
    }
}

