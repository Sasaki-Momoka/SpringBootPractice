package com.example.demo.service.contact;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.contact.Contact;
import com.example.demo.form.contact.ContactForm;

public interface ContactService {

	List<Contact> getContactlist();

	void saveContact(ContactForm contactForm);

	// public Contact getDetailById(Long id); 
	 
	  Optional<Contact> getDetailById(Long id);



	  public Optional<Contact> deleteById(Long id);


	}



