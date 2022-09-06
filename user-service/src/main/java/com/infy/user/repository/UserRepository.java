package com.infy.user.repository;


import com.infy.user.dto.UserDTO;
import com.infy.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserId(Long userId);


}
