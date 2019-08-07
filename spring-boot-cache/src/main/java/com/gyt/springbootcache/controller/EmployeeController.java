package com.gyt.springbootcache.controller;

import com.gyt.springbootcache.bean.Employee;
import com.gyt.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee emp = employeeService.getEmpById(id);
        return emp;
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        Employee updateEmployee = employeeService.updateEmp(employee);
        return updateEmployee;
    }

    @GetMapping("/delemp")
    public String deleteEmp(Integer id) {
        employeeService.deleteEmp(id);
        System.out.println("del: " + id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastname}")
    public Employee getEmpByLastName(@PathVariable("lastname") String lastName) {
        return employeeService.getEmpByLastName(lastName);
    }
}
