package com.example.demo.form.admin;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminForm implements Serializable {

	@NotBlank(message = "姓を入力してください")
	private String lastName;

	@NotBlank(message = "名を入力してください")
	private String firstName;

	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "正しいメールアドレスを入力してください")
	private String email;

	@NotBlank(message = "パスワードを設定してください")
	@Size(min = 8, message = "パスワードは8文字以上で入力してください")
	private String password;

}
