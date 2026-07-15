package com.example.demo.entity.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "users")
@Data

public class AdminEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column  (name = "last_name",nullable = false)
	private String lastName;
	
	@Column  (name = "first_name",nullable = false)
	private String firstName;
	
    @Column  (name = "email",nullable = false)
    private String email;
    
    @Column  (name = "password",nullable = false)
    private String password;


	public boolean hasErrors() {
		return false;
	}

    
    
	/*	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "姓を入力してください")
		String lastName;
		
		@NotBlank(message = "名を入力してください")
		String firstName;
		
	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "メールアドレスの形式が正しくありません")
	private String email;
	
	@NotBlank(message = "パスワードを入力してください")
	@Size(min = 8, message = "パスワードは8文字以上で入力してください")
	private String password;
	*/
	
}
