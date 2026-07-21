package com.example.demo.service.admin;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SigninUserDetailsServiceImpl implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		if (username.equals("jhon")) {
			return new SigninUser("jhon","pass",Collections.emptyList());
		} else {
			throw new UsernameNotFoundException(username + " => 指定しているユーザー名は存在しません");
		}
	}
	

}
