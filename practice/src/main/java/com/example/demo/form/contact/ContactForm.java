package com.example.demo.form.contact;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContactForm implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Long id;

	@NotBlank (message = "姓を入力してください")
	private String lastName;

	@NotBlank (message = "名を入力してください")
	private String firstName;

	@NotBlank (message = "メールアドレスを入力してください")
	@Email (message = "メールアドレスの形式が正しくありません")
	private String email;

	@NotBlank (message = "パスワードを入力してください")
	@Size(min = 10, max = 11 ) 
	private String phone;

	@NotBlank
	@Pattern(regexp = "[0-9]{3}[-]{0,1}[0-9]{4}")
	private String zipCode;

	@NotBlank
	private String address;

	@NotBlank
	private String buildingName;

	@NotEmpty
	private String contactType;

	@NotBlank
	private String body;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public Long setId(Long id) {
		return this.id = id;
	}

	public boolean hasErrors() {
		return false;
	}

}
