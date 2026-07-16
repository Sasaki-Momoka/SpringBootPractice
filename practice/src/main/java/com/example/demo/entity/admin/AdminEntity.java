package com.example.demo.entity.admin;

import com.example.demo.form.admin.AdminForm;

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

	public static void saveAdmin(AdminForm adminForm) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

    
    

	
}
