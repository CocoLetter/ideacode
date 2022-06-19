package com.codebaker.springbootmybatis0618.mapper;


import com.codebaker.springbootmybatis0618.bean.Employee;

//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
