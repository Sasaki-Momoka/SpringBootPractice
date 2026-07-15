package com.example.demo.repository.admin;

/*import org.apache.catalina.User;*/
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.form.admin.AdminForm;


public interface AdminRepository extends JpaRepository<AdminForm,Long> {
  
}
