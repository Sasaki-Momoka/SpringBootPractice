package com.example.demo.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.admin.AdminEntity;
import com.example.demo.form.admin.AdminForm;
import com.example.demo.repository.admin.AdminRepository;

import jakarta.transaction.Transactional;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository; 
	
	/*	@Override
		public List<AdminForm> saveUser() {
			List<AdminForm> form = adminRepository.findAll();
			return form;
		}
	*/
	
	
	@Override
	@Transactional
	public AdminEntity save(AdminForm adminForm) {
		
		AdminEntity form = adminRepository.findById(adminForm.getId()).orElseThrow();
		
		//AdminForm form = new AdminForm();
		//AdminForm entity = (AdminForm) edit.get();

		form.setLastName(adminForm.getLastName());
		form.setFirstName(adminForm.getFirstName());
		form.setEmail(adminForm.getEmail());
		form.setPassword(adminForm.getPassword());
		
		return  adminRepository.save(form);
	}

	@Override
	public AdminForm saveUser(AdminForm adminForm) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	
			
	
	
	
	
	

}
