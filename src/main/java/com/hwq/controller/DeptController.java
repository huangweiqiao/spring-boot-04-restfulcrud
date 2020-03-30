package com.hwq.controller;

import com.hwq.bean.Department;
import com.hwq.bean.Employee;
import com.hwq.mapper.DepartmentMapper;
import com.hwq.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController 不返回页面 是返回json格式
@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptByid(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.inserDept(department);
        return department;
    }

    @GetMapping("/empMybatis/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}
