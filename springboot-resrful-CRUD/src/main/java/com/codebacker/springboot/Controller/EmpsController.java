package com.codebacker.springboot.Controller;

import com.codebacker.springboot.dao.DepartmentDao;
import com.codebacker.springboot.dao.EmployeeDao;
import com.codebacker.springboot.entities.Department;
import com.codebacker.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;


@Controller
public class EmpsController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String empsFindAll(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emps/list";
    }
    //插入员工信息
    @GetMapping("/emp")
    public String empInsert(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/insert";
    }
    @PostMapping("/emp")
    public ModelAndView empInsertFinal(@Valid Employee employee, Errors errors){
        ModelAndView modelAndView = new ModelAndView();
        if(errors.hasErrors()){
            List<FieldError> b = errors.getFieldErrors();
            for(FieldError i : b){
                System.out.println(i.getField()+" "+i.getDefaultMessage());
            }
            modelAndView.setViewName("redirect:/emp");
        }else{
            modelAndView.setViewName("redirect:/emps");
        }
        System.out.println("保存的员工信息："+employee);
        employeeDao.save(employee);
        return modelAndView;
    }
    @GetMapping("/emp/{id}")
    public String empUpdateById(@PathVariable("id") Integer id,Model model){

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        return "forward:/emp";
    }

    @PutMapping("/emp")
    public String empUpdateByIdFinal(Employee employee){

        System.out.println(employee);
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String empDeleteById(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
