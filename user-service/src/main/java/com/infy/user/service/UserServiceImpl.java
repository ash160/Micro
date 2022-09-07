package com.infy.user.service;



import com.infy.user.dto.DepartmentDTO;

import com.infy.user.dto.UserDTO;
import com.infy.user.entity.User;
import com.infy.user.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class UserServiceImpl implements UserService{
	
	Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public User saveUser(User user) {
    	logger.info("Inside saveUser method of UserService Implementation");
        return userRepository.save(user);
    }

    @Override
    public User fetchByUserId(Long userId) {
    	logger.info("Inside fetchByUserId method of UserService Implementation");
        return userRepository.findByUserId(userId);
    }

    @Override
    public UserDTO fetchAllUserDetails(Long userId) {
    	
    	logger.info("Inside fetchAllUserDetails method of UserService Implementation");

        User user=userRepository.findByUserId(userId);
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setDepartmentId(user.getDepartmentId());
       // DepartmentDTO departmentDTO=restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(), DepartmentDTO.class);
        DepartmentDTO departmentDTO=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), DepartmentDTO.class);
        
        userDTO.setDepartments(departmentDTO);
        return userDTO;
    }


}
