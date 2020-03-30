package com.hwq.controller;

import com.hwq.dao.DepartmentDao;
import com.hwq.dao.EmployeeDao;
import com.hwq.entities.Department;
import com.hwq.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        //thymeleaf默认会拼串
        // classpath:/templates/xxx.html   (xxx就是我们的返回值)
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //页面下拉框显示所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //去到添加页面
        return "emp/add";
    }

    //添加员工
    //springmvc将参数和入参对象一一绑定，参数名字和入参bean的属性名要一直
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        //保存员工
        employeeDao.save(employee);
        //添加成功回到员工列表页面
        //redirect 表示重定向一个地址，forward后台转发 ,/ 代表当前项目路径
        return "redirect:/emps";
    }


   //去到修改页面前查询当前员工信息
   @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
       Employee employee = employeeDao.get(id);
       model.addAttribute("emp",employee);
       //页面下拉框显示所有部门
       Collection<Department> departments = departmentDao.getDepartments();
       model.addAttribute("depts",departments);
       //回到修改页面
       return "emp/add";
   }

   //员工修改
   @PutMapping("/emp")
    public String updateEmployee(Employee employee){
       System.out.println(employee);
       employeeDao.save(employee);
       return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
