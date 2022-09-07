package com.infy.department.service.controller;

import com.infy.department.service.dto.DepartmentDTO;

import com.infy.department.service.entity.Department;
import com.infy.department.service.service.DepartmentService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	Log logger = LogFactory.getLog(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
    	 logger.info("Inside saveDepartment method of Department Controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public DepartmentDTO findDepartmentById(@PathVariable("id") Long departmentId){
    	 logger.info("Inside findDepartmentById method of Department Controller");
        return departmentService.findDepartmentById(departmentId);
    }





}
