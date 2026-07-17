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
	
	//  画面から送られてきたAdminFormを受け取る　処理が終わった後にAdminServiceに返す
	//  saveAdminは処理の名前
	// 管理者情報を保存して、その結果を返す処理
	@Override
	@Transactional
	public void saveAdmin(AdminForm adminForm) {
		
		//  新しいオブジェクトを作成
		//  AdminFormクラスからadminsという名前のオブジェクトを作る
		//  メモリ上に新しいAdminFormが準備される
		AdminEntity admin = new AdminEntity();
		
		//  adminFormから取得した各々のデータを管理者オブジェクト(admins)にコピー
		// admins.save()を使用する
		admin.setLastName(adminForm.getLastName());
		admin.setFirstName(adminForm.getFirstName());
		admin.setEmail(adminForm.getEmail());
		admin.setPassword(adminForm.getPassword());
		//　　formで入力されやデータをadminRepositoryが持っている　　メソッドに渡してDBに保存
		 adminRepository.save(admin);
	}
}
