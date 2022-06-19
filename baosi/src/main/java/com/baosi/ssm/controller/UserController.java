package com.baosi.ssm.controller;

import com.baosi.ssm.domain.Role;
import com.baosi.ssm.domain.UserInfo;
import com.baosi.ssm.domain.UserResult;
import com.baosi.ssm.service.IUserService;
import com.baosi.ssm.utils.String2IntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    private IUserService userService;

    //用户添加角色
    @RolesAllowed("ADMIN")
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleId) {
        userService.addRoleToUser(userId, roleId);
        return "redirect:findAll.do";
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole")
    @RolesAllowed("ADMIN")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据id查询用户
        UserInfo userInfo = userService.findById(id);
        //根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(id);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    //查询指定id的用户
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    //用户添加
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    //用户查询
    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList", userList);
        mv.setViewName("user-list");
        return mv;
    }

    //删除用户
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/delUser")
    public @ResponseBody
    UserResult delUser(@RequestParam("delItems") String items) {
        UserResult result = new UserResult();
        //将字符串分割成数组
        String[] str = items.split(",");
        //调用方法实现字符串数组到int数组的转换
        int[] arr = String2IntegerUtils.String2Int(str);
        for (int id : arr) {
            try {
                userService.delUser(id);
                result.setSuccess(true);
            } catch (Exception e) {
                result.setSuccess(false);
                e.printStackTrace();
            }
        }
        return result;
    }
}
