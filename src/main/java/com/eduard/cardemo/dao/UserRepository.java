package com.eduard.cardemo.dao;


import com.eduard.cardemo.entity.Make;
import com.eduard.cardemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserName(String userName);

}
