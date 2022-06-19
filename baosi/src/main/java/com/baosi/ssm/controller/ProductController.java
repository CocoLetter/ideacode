package com.baosi.ssm.controller;

import com.baosi.ssm.domain.Product;
import com.baosi.ssm.domain.ProductResult;
import com.baosi.ssm.service.IProductService;
import com.baosi.ssm.utils.ImageUtils;
import com.baosi.ssm.utils.String2IntegerUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")

public class ProductController {

    @Autowired
    private IProductService productService;

    //跳转到预览页面
    @RequestMapping("/toViewProduct")
    public ModelAndView toPreviewNews(int id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.setViewName("product-view");
        return mv;
    }

    //跳转到修改产品页面
    @RequestMapping("/toUpdateProduct")
    public ModelAndView toUpdateNews(int id) {
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(id);
        mv.addObject("product", product);
        mv.setViewName("product-update");
        return mv;
    }

    //预览产品
    @RequestMapping(path = "/view", method = RequestMethod.POST)
    public @ResponseBody
    ProductResult viewImageById(@RequestParam("id") int id) {
        ProductResult result = new ProductResult();
        try {
            Product product = productService.findById(id);
            result.setProductData(product);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
    
    //删除产品
    @RequestMapping(path = "/delProduct", method = RequestMethod.POST)
    public @ResponseBody
    ProductResult deleteImageById(@RequestParam("delItems") String items, HttpServletRequest request) {
        ProductResult result = new ProductResult();
        String imgPath,prodParamPath;
        String imgUrl,prodParamUrl;
        //将字符串分割成数组
        String[] str = items.split(",");
        //调用方法实现字符串数组到int数组的转换
        int[] arr = String2IntegerUtils.String2Int(str);
        String path = request.getSession().getServletContext().getRealPath("/");
        for (int id : arr) {
            //获取要上传到的目标文件目录
            imgUrl = productService.findById(id).getUrl();
            prodParamUrl = productService.findById(id).getProdParamUrl();
            imgPath = path + imgUrl;
            prodParamPath = path+prodParamUrl;
            //将本地文件夹中的文件删除
            try {
                //创建file对象
                File file = new File(imgPath);
                File fileProdParam = new File(prodParamPath);
                try {
                    if (file.exists()||fileProdParam.exists()) {
                        //删除文件
                        file.delete();
                        fileProdParam.delete();
                        //数据库中删除文件名
                        productService.deleteProductById(id);
                        result.setSuccess(true);
                    } else {
                        System.out.println("要删除的文件不存在！");//模拟日志打印
                        productService.deleteProductById(id);//直接删除名称
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

    //产品添加
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String save(Product product, HttpServletRequest request, MultipartFile pictureFile, MultipartFile prodParamFile) throws Exception {
        // 得到上传图片的地址
        String imgPath,prodParamPath;
        try {
            //ImageUtils为之前添加的工具类
            imgPath = ImageUtils.upload(request, pictureFile);
            prodParamPath = ImageUtils.upload(request, prodParamFile);
            if (imgPath != null ) {
                // 将上传图片的地址封装到实体类
                product.setUrl(imgPath);
                System.out.println("-----------------图片上传成功！");
            } else {
                System.out.println("-----------------图片上传失败！");
            }
            if (prodParamPath != null ) {
                // 将上传图片的地址封装到实体类
                product.setProdParamUrl(prodParamPath);
                System.out.println("-----------------参数表上传成功！");
            } else {
                System.out.println("-----------------参数表上传失败！");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("----------------图片上传失败！");
        }
        productService.save(product);
        return "redirect:findAll.do";
    }

    //产品编辑
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String update(Product product, HttpServletRequest request, MultipartFile pictureFile, MultipartFile prodParamFile) throws Exception {
        // 得到上传图片的地址
        String imgPath,prodParamPath;
        try {
            //ImageUtils为之前添加的工具类
            imgPath = ImageUtils.upload(request, pictureFile);
            prodParamPath = ImageUtils.upload(request, prodParamFile);
            if (imgPath != null ) {
                // 将上传图片的地址封装到实体类
                product.setUrl(imgPath);
                System.out.println("-----------------图片上传成功！");
            } else {
                System.out.println("-----------------图片上传失败！");
            }
            if (prodParamPath != null ) {
                // 将上传图片的地址封装到实体类
                product.setProdParamUrl(prodParamPath);
                System.out.println("-----------------参数表上传成功！");
            } else {
                System.out.println("-----------------参数表上传失败！");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("----------------图片上传失败！");
        }
        productService.update(product);
        return "redirect:findAll.do";
    }



    //查询所有产品 --分页
    @RequestMapping("/findAll")
    @RolesAllowed({"ADMIN", "USER"})
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(ps);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-page-list");
        return mv;
    }
}
