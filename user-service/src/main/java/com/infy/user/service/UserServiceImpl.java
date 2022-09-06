package com.infy.user.service;

import com.infy.user.dto.UserDTO;
import com.infy.user.entity.User;
import com.infy.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    @Override
    public User fetchByUserId(Long userId) {
        log.info("Inside fetchByUserId method of UserService");
        return userRepository.findByUserId(userId);
    }

    @Override
    public UserDTO getUserProfile(Long userId) {
        return userRepository.findByUsersId(userId);
    }


}
