package com.example.demo.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public AdminService saveAdmin(AdminForm adminForm) {
		
		//DBにデータがあって引っ張ってくる時だからいらない？
		// AdminEntity form = adminRepository.findById(adminForm.getId()).orElseThrow();
		
		AdminForm admins = new AdminForm();
		//AdminForm entity = (AdminForm) edit.get();

		admins.setLastName(adminForm.getLastName());
		admins.setFirstName(adminForm.getFirstName());
		admins.setEmail(adminForm.getEmail());
		admins.setPassword(adminForm.getPassword());
		
		//　　formで入力されやデータをadminRepositoryが持っている　　メソッドに渡してDBに保存
		return  adminRepository.save(admins);
	}

	@Override
	public AdminForm saveUser(AdminForm adminForm) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	
			
	
	
	
	
	

}
