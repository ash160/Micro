package com.infy.user.controller;

import com.infy.user.dto.DepartmentDTO;
import com.infy.user.dto.UserDTO;
import com.infy.user.entity.User;
import com.infy.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
   public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method of UserController");
       return userService.saveUser(user);
   }

   @GetMapping("/{id}")
    public User fetchUserById(@PathVariable ("id") Long userId){
       log.info("Inside  fetchUserById method of UserController");

       return userService.fetchByUserId(userId);
   }


    //    RestTemplate restTemplate = new RestTemplate();
//    String fooResourceUrl
//            = "http://localhost:8080/spring-rest/foos";
//    ResponseEntity<String> response
//            = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
//Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
//




    @GetMapping("/fetching/{id}")
    public UserDTO fetchUserDetailsById(@PathVariable ("id") Long userId){
        UserDTO userDTO=userService.getUserProfile(userId);

        System.out.println(userDTO);

        return UserDTO;



    }





}
