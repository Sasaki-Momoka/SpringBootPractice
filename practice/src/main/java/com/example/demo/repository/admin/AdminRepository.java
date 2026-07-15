package com.example.demo.repository.admin;

/*import org.apache.catalina.User;*/
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.admin.AdminEntity;


public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
  
}
