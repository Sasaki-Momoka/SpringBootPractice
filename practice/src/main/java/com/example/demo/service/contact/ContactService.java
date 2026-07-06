package com.example.demo.service.contact;

import java.util.List;

import com.example.demo.entity.contact.Contact;
import com.example.demo.form.contact.ContactForm;

public interface ContactService {

	List<Contact> getContactlist();

	void saveContact(ContactForm contactForm);

}
