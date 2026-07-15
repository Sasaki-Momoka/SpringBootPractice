package com.example.demo.form.admin;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminForm implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@NotBlank (message = "姓を入力してください")
	private String lastName;
	
	@NotBlank (message = "姓を入力してください")
	private String firstName;
	
	@NotBlank (message = "メールアドレスを入力してください")
	@Email (message = "正しいメールアドレスを入力してください")
	private String email;
	
	@NotBlank (message = "パスワードを設定してください")
	@Size (min = 8, message = "パスワードは8文字以上で入力してください")
	private String password;
	
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) { this.firstName = firstName; }
	
	public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public Long getId(Long id) {
		return this.id = id;
	}
    
    public Long setId(Long id) {
    	return this.id = id;
    }
    public boolean hasrrors() {
    	return false;
    }

}
	

