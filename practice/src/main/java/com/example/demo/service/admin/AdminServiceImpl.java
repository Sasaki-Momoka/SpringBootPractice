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
	
	@Override
	@Transactional
	
	//  画面から送られてきたAdminFormを受け取る　処理が終わった後にAdminServiceに返す
	//  saveAdminは処理の名前
	// 管理者情報を保存して、その結果を返す処理
	public AdminService saveAdmin(AdminForm adminForm) {
		
		//DBにデータがあって引っ張ってくる時だからいらない？
		// AdminEntity form = adminRepository.findById(adminForm.getId()).orElseThrow();
		
		//  新しいオブジェクトを作成
		//  AdminFormクラスからadminsという名前のオブジェクトを作る
		//  メモリ上に新しいAdminFormが準備される
		AdminForm admins = new AdminForm();
		//AdminForm entity = (AdminForm) edit.get();
		
		//  adminFormから取得した各々のデータを管理者オブジェクト(admins)にコピー
		// admins.save()を使用する
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

	@Override
	public void save(AdminForm adminForm) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	
			
	
	
	
	
	

}
