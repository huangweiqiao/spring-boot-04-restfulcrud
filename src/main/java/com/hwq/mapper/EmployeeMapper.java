package com.hwq.mapper;


import com.hwq.bean.Employee;

/**
 * 使用配置文件的方式
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
