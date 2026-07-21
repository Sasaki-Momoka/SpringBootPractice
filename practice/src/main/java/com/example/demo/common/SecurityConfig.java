package com.example.demo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/*	@Bean
				public PasswordEncoder passwordEncoder() {
					return new BCryptPasswordEncoder();
		}
	*/
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;


	public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http

				.formLogin(login -> login
						.loginPage("/admin/signin")
						.loginProcessingUrl("/admin/signin")
						.defaultSuccessUrl("/admin/contacts")
						.permitAll())

				.logout(logout -> logout
						.logoutSuccessUrl("/admin/signin?logout")
						.permitAll())

				.authorizeHttpRequests(authz -> authz
						.requestMatchers("/admin/signup", "/admin/signin", "/contact/**")
						.permitAll()
						.requestMatchers("/admin/contacts", "/admin/contacts/{id}", "/admin/contacts/{id}/edit")
						.hasRole("ADMIN"));

		return http.build();

	}

}
