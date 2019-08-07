package com.gyt.springbootcache.controller;

import com.gyt.springbootcache.bean.Department;
import com.gyt.springbootcache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        Department deptById = deptService.getDeptById(id);
        return deptById;
    }
}
