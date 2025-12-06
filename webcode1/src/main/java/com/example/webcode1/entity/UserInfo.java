package com.example.webcode1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "userinfo")
@Data // Lombok自动生成Getter/Setter
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
}