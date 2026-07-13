package com.example.demo.service.contact;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.contact.Contact;
import com.example.demo.form.contact.ContactForm;

public interface ContactService {

	List<Contact> getContactlist();

	void saveContact(ContactForm contactForm);

	 
	  Optional<Contact> getDetailById(Long id);



	  public void deleteById(Long id);

	Contact getEditById(Long id);

	Contact getEditById(ContactForm contactForm);









	  
	 
	  


	}



