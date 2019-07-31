package com.gyt.springboot.controller;

import com.gyt.springboot.dao.DepartmentDao;
import com.gyt.springboot.dao.EmployeeDao;
import com.gyt.springboot.entities.Department;
import com.gyt.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    // 查询所有员工，返回列表页面, model是为了页面回写传递值
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        // 加入请求域中
        model.addAttribute("emps", employees);
        // themyleaf 自动拼串  /templates/list.html
        return "emp/list";
    }

    // 来到添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 先查出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 员工添加
    // SpringMVC自动将请求参数和入参对象的属性进行一一绑定：请求参数的名字和入参对象的属性名相同
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        // redirect forward
        return "redirect:/emps";
    }

    // 来到修改页面，查出当前员工，页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        // 页面要显示部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        // 回到修改添加二合一页面
        return "emp/add";
    }

    // 员工修改功能, 需要提交员工ID
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
