package com.example.demo.service.admin;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.admin.AdminEntity;
import com.example.demo.entity.admin.UserDetail;
import com.example.demo.repository.admin.AdminRepository;


@Service
public class SigninUserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		System.out.println("テスト１");
		//  AdminRepositoryからメールアドレスが一致する情報をデータベースから取得
		AdminEntity admin = adminRepository.findByEmail(username);
		System.out.println("テスト２");
		System.out.println(adminRepository.getClass());
		//  もし見つからなかった場合にユーザーが存在しませんという例外を発生する
				if (admin == null) {
					System.out.println("テスト３");
					throw new UsernameNotFoundException("ユーザーが存在しません");
				}
		//  見つかった情報をUserDetailへ返す
		return new UserDetail(
				admin.getEmail(),
				admin.getPassword(),
				Collections.emptyList()
				);
		
	}
	

}
