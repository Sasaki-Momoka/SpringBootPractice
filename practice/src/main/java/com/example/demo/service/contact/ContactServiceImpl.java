package com.example.demo.service.contact;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.contact.Contact;
import com.example.demo.form.contact.ContactForm;
import com.example.demo.repository.contact.ContactRepository;

import jakarta.transaction.Transactional;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> getContactlist() {
		List<Contact> list = contactRepository.findAll();
		return list;
	}
	
	@Transactional
	public Optional<Contact> getDetailById(Long id) {
		System.out.println("Serviceにいるよ");
		Optional<Contact> detail = contactRepository.findById(id);
		return detail;
		//return contactRepository.findById(id);
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

		contact.setCreatedAt(contactForm.getCreatedAt());
		contact.setUpdatedAt(contactForm.getUpdatedAt());

		contactRepository.save(contact);
	}
	
	

}
