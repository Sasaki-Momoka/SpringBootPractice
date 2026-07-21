package com.example.demo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}
	/*	
		@Bean 
		InMemoryUserDetailsManager userDetailService() {
			UserDetails admin =  User
			.withUsername("admin")
			.password(passwordEncoder().encode("admin"))
			.roles("ADMIN")
			.build();
			
			UserDetails user = User
					.withUsername("user")
					.password(passwordEncoder().encode("user"))
					.roles("USER")
					.build();
				
		
			
			return new InMemoryUserDetailsManager(admin,user);
		}*/

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
						.hasRole("ADMIN"))
		
		 		.logout(logout -> logout                  
		 				.logoutUrl("/logout")
		 				.logoutSuccessUrl("/login?logout")
		 				.invalidateHttpSession(true)   
		 				.deleteCookies("JSESSIONID")        
		 				);

		return http.build();

	}

}

/*@Override
protected void configure(HttpSecurity http) throws Exception {
	
	http.authorizeHttpRequests(authorize -> authorize
			.requestMatchers("/admin/signin")
	
}*/