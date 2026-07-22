package com.example.demo.form.admin;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdminSigninForm implements Serializable {
	private String email;
	private String password;
}
