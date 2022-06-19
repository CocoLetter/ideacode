package com.baosi.ssm.controller.front;

import com.baosi.ssm.domain.ImageSlide;
import com.baosi.ssm.domain.Product;
import com.baosi.ssm.domain.ProductResult;
import com.baosi.ssm.service.IImageSlideService;
import com.baosi.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product-pre")

public class PreProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IImageSlideService imageSlideService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        //查询轮播图片
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        //查询所有产品
        List<Product> ps = productService.findAllPre();
        //放入视图中
        mv.addObject("imageSlideList", imageSlideList);
        mv.addObject("productList", ps);
        mv.setViewName("/front/product");
        return mv;
    }

    //跳转到产品页面
    @RequestMapping("/toProduct.do")
    public String toProduct(@RequestParam(value = "index",defaultValue = "0") int index, @RequestParam(value = "lang",defaultValue = "0") int lang) throws Exception {
        //获取最新产品的id
        List<Product> productList;
        int id;
        if (lang == 1) {
            productList= productService.findAllPre_en();
            if (productList!=null){
                id = productList.get(index).getId();
                return "redirect:findById.do?lang=1&id="+id;
            }
            else//没有产品就调到首页吧
                return "front/index";
        }
        else{
            productList = productService.findAllPre();
            if (productList!=null){
                id = productList.get(index).getId();
                return "redirect:findById.do?id="+id;//跳中文
            }
            else
                return "front/index";
        }
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public ModelAndView findById(@RequestParam(name = "id", required = true, defaultValue = "3") int id, @RequestParam(value = "lang",defaultValue = "0") int lang) throws Exception {
        ModelAndView mv = new ModelAndView();
        //查询轮播图片
        List<ImageSlide> imageSlideList = imageSlideService.findAll();
        //查询所有产品
        List<Product> ps=null;
        Product proFor,proBack;
        if (lang == 1) {
            ps = productService.findAllPre_en();
            proFor = productService.findProFor_en(id);
            proBack = productService.findProBack_en(id);
        }else {
            ps = productService.findAllPre();
            //查询上一篇
            proFor = productService.findProFor(id);
            //查询下一篇
            proBack = productService.findProBack(id);
        }
        //查询当前产品
        Product pro = productService.findById(id);
        //放入视图中
        mv.addObject("imageSlideList", imageSlideList);
        mv.addObject("productList", ps);
        mv.addObject("pro", pro);
        mv.addObject("proFor",proFor);
        mv.addObject("proBack",proBack);
        if (lang == 1){
            mv.setViewName("/front/product_en");
        }else {
            mv.setViewName("/front/product");
        }
        return mv;
    }


    @RequestMapping(value = "/getProductList",method = RequestMethod.GET)
    @ResponseBody
    public ProductResult getProductList( @RequestParam(value = "lang",defaultValue = "0") int lang) throws Exception {
        ProductResult result = new ProductResult();
        List<Product> productList;
        if (lang == 1){
            productList = productService.findAllPre_en();
        }else {
            productList = productService.findAllPre();
        }
        if (productList!=null){
            result.setSuccess(true);
            result.setProductList(productList);
        }else {
            result.setSuccess(false);
        }
        return result;
    }


}
