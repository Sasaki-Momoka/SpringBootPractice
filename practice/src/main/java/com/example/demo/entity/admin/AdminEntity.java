package com.example.demo.entity.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Table(name = "users")
@Data

public class AdminEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "姓を入力してください")
	String last_name;
	
	@NotBlank(message = "名を入力してください")
	String first_name;
	
    @NotBlank(message = "メールアドレスを入力してください")
    @Email(message = "メールアドレスの形式が正しくありません")
    private String email;
    
    @NotBlank(message = "パスワードを入力してください")
    @Size(min = 8, message = "パスワードは8文字以上で入力してください")
    private String password;
    
    
	
}
