package com.example.demo.repository.contact;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.contact.Contact;
import com.example.demo.form.contact.ContactForm;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	void saveAll(ContactForm contactForm);

	}


