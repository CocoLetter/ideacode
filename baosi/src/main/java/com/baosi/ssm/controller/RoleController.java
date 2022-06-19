package com.baosi.ssm.controller;

import com.baosi.ssm.domain.Permission;
import com.baosi.ssm.domain.Role;
import com.baosi.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")

public class RoleController {

    @Autowired
    private IRoleService roleService;

    //角色添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionId) {
        roleService.addPermissionToRole(roleId, permissionId);
        return "redirect:findAll.do";
    }

    //查询角色以及角色可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        List<Permission> otherP = roleService.findOtherP(id);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherP);
        mv.setViewName("role-permission-add");
        return mv;
    }

    //查询指定角色权限
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }

    //角色添加
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //角色查询
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }
}
