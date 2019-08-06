package com.gyt.springboot.mapper;

import com.gyt.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @className: DepartmentMapper
 * @author guyt
 * @description: 类描述
 * @date 2019/8/6
 * @version 1.0.0
 */
// 指定这是一个操作数据库的mapper
// 注解版
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set departmentN_name = #{departmentName} where id = #{id}}")
    int updateDept(Department department);
}
