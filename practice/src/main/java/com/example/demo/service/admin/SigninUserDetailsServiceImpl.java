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
public class SigninUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		//  AdminRepositoryからメールアドレスが一致する情報をデータベースから取得
		AdminEntity admin = adminRepository.findByEmail(email);
		//  もし見つからなかった場合にユーザーが存在しませんという例外を発生する
		if (admin == null) {
			throw new UsernameNotFoundException(email + "ユーザーが存在しません");
		}
		//  見つかった情報をUserDetailへ返す
		return new UserDetail(
				admin.getEmail(),
				admin.getPassword(),
				Collections.emptyList());
	}
}
