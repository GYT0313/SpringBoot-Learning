package com.gyt.springboot.mapper;

import com.gyt.springboot.bean.Employee;

public interface EmployeeMapper {

     Employee getEmpById(Integer id);

     void insertEmp(Employee employee);
}
