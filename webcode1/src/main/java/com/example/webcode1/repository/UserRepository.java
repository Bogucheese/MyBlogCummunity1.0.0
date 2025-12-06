package com.example.webcode1.repository;


import com.example.webcode1.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    // JPA 会自动根据方法名生成 SQL: select * from userinfo where username = ?
    UserInfo findByUsername(String username);
}
