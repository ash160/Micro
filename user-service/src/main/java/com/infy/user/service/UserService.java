package com.infy.user.service;

import com.infy.user.dto.UserDTO;
import com.infy.user.entity.User;


public interface UserService {
   public User saveUser(User user);

  public User fetchByUserId(Long userId);


   public  UserDTO fetchAllUserDetails(Long userId);
}
