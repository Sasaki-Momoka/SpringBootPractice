package com.example.demo.service.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.contact.Contact;
import com.example.demo.form.contact.ContactForm;
import com.example.demo.repository.contact.ContactRepository;



@Service
public class ContactServiceImpl implements ContactService {
	
	public void sss() {
		System.out.println("テスト");
	}

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public List<Contact> getContactlist() {
		return contactRepository.findAll();
	}
	
	
	@Override
	public void saveContact(ContactForm contactForm) {
		Contact contact = new Contact();
		contact.setLastName(contactForm.getLastName());
		contact.setFirstName(contactForm.getFirstName());
		contact.setEmail(contactForm.getEmail());
		contact.setPhone(contactForm.getPhone());
		contact.setZipCode(contactForm.getZipCode());
		contact.setAddress(contactForm.getAddress());
		contact.setBuildingName(contactForm.getBuildingName());
		contact.setContactType(contactForm.getContactType());
		contact.setBody(contactForm.getBody());

		contact.setCreated(contactForm.getCreated());
		contact.setUpdated(contactForm.getUpdated());

		contactRepository.save(contact);
	}
	

	
}
