package com.infy.department.service.service;


import com.infy.department.service.dto.DepartmentDTO;
import com.infy.department.service.entity.Department;

public interface DepartmentService {


   public Department saveDepartment(Department department);

  public DepartmentDTO findDepartmentById(Long departmentId);
}
