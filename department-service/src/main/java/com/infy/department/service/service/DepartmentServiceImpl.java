package com.infy.department.service.service;


import com.infy.department.service.dto.DepartmentDTO;
import com.infy.department.service.entity.Department;
import com.infy.department.service.repository.DepartmentRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	Log logger = LogFactory.getLog(DepartmentServiceImpl.class);
	
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
    	 logger.info("Inside saveDepartment method of DepartmentService Implementation");
        return departmentRepository.save(department);
    }

    @Override
    public DepartmentDTO findDepartmentById(Long departmentId) {
    	
    	logger.info("Inside findDepartmentById method of DepartmentService Implementation");

        Department department=departmentRepository.findByDepartmentId(departmentId);
        DepartmentDTO departmentDTO=new DepartmentDTO();

        departmentDTO.setDepartmentId(department.getDepartmentId());
        departmentDTO.setDepartmentAddress(department.getDepartmentAddress());
        departmentDTO.setDepartmentCode(department.getDepartmentCode());
        departmentDTO.setDepartmentName(department.getDepartmentName());

        return departmentDTO;
    }
}
