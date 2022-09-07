package com.infy.user.controller;
import com.infy.user.dto.UserDTO;

import com.infy.user.entity.User;
import com.infy.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

	Log logger = LogFactory.getLog(UserController.class);
	
    @Autowired
    private UserService userService;


    @PostMapping("/")
   public User saveUser(@RequestBody User user){
    	 logger.info("Inside saveUser method of User Controller");
       return userService.saveUser(user);
   }

   @GetMapping("/{id}")
    public User fetchUserById(@PathVariable ("id") Long userId){
	   logger.info("Inside fetchUserById method of User Controller");
       return userService.fetchByUserId(userId);
   }

   @CircuitBreaker(name="userService",fallbackMethod="fetchAllUserDetailsFallback")
   @GetMapping("/fetchdetails/{id}")
    public UserDTO fetchAllUserDetails(@PathVariable ("id") Long userId){
	   logger.info("Inside fetchAllUserDetails method of User Controller");
        return userService.fetchAllUserDetails(userId);

   }
   
   
   public UserDTO fetchAllUserDetailsFallback(Long userId,Throwable throwable) {
	   logger.info("========================fetchAllUserDetails Fallback==============================");
	   return new UserDTO();
   }

   
   



}
