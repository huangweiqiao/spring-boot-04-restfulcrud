package com.hwq.mapper;

import com.hwq.bean.Department;
import org.apache.ibatis.annotations.*;

//@Mapper 指定这是一个操作数据的mapper
//@Mapper  //在springboot启动类(com.hwq.SpringBoot04RestfulCurdApplication.java)上加了 @MapperScan(value = "com.hwq.mapper")批量扫描注解，所以在这里就不需要加了
public interface DepartmentMapper {

    @Select("select id,department_name from department where id=#{id}")
    public Department getDeptByid(Integer id);

    @Delete("delete * from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department (department_name) values (#{departmentName})")
    public int inserDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDeptById();

}
