package com.example.demo.service.admin;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.admin.AdminForm;
import com.example.demo.repository.admin.AdminRepository;

import jakarta.transaction.Transactional;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	
	@Transactional
	public void saveUser(AdminForm adminForm) {
		User entity = new User();
		
		entity.setLastName(adminForm.getLastName());
	}
			
	
	
	
	
	

}
