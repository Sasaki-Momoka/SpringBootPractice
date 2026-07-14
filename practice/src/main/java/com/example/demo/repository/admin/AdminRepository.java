package com.example.demo.repository.admin;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<User, Long> {
  
}
