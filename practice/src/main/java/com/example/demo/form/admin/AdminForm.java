package com.example.demo.form.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AdminForm {
	
	@NotBlank(message = "姓を入力してください")
	private String last_name;
	@NotBlank(message = "姓を入力してください")
	private String first_name;
	
	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "正しいメールアドレスを入力してください")
	private String email;
	
	@NotBlank(message = "パスワードを設定してください")
	@Size(message = "パスワードは8文字以上で入力してください")
	private String password;
	
	public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
	

