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
		Optional<Contact> detail = contactRepository.findById(id);
		return detail;
	}
	
	@Transactional
	public void deleteById(Long id) {
		contactRepository.deleteById(id);	
	}
	
	
	@Transactional
	
public Contact upateForm(Long id) {
		Optional<Contact>  edit = contactRepository.findById(id);
		Contact entity = edit.get();
		
		Contact form = new Contact();
		
		form.setLastName(entity.getLastName());
		form.setFirstName(entity.getFirstName());
		form.setEmail(entity.getEmail());
		form.setPhone(entity.getPhone());
		form.setZipCode(entity.getZipCode());
		form.setAddress(entity.getAddress());
		form.setBuildingName(entity.getBuildingName());
		form.setContactType(entity.getContactType());
		form.setBody(entity.getBody());
		
		
		return contactRepository.save(entity);
		
	}
	/*	@Transactional
		public Optional<Contact> getDEditById(Long id) {
			Optional<Contact> edit = contactRepository.findById(id);
			return edit;
		}*/


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
