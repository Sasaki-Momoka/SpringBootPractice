package com.example.demo.service.contact;

import java.time.LocalDateTime;
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

	public Contact getEditById(Long id) {
		Optional<Contact> edit = contactRepository.findById(id);
		Contact entity = edit.get();
		ContactForm form = new ContactForm();

		form.setId(entity.getId());
		form.setLastName(entity.getLastName());
		form.setFirstName(entity.getFirstName());
		form.setEmail(entity.getEmail());
		form.setPhone(entity.getPhone());
		form.setZipCode(entity.getZipCode());
		form.setAddress(entity.getAddress());
		form.setBuildingName(entity.getBuildingName());
		form.setContactType(entity.getContactType());
		form.setBody(entity.getBody());

		System.out.println("テスト動いてない");
		return contactRepository.save(entity);

	}

	@Override
	@Transactional
	public void saveContact(ContactForm contactForm) {
		
		Contact contact = contactRepository.findById(contactForm.getId()).orElseThrow();

		System.out.println("serviceです");
		System.out.println(contactForm.getId());

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
		contact.setUpdatedAt(LocalDateTime.now());

		System.out.println(contact.getId());
		contactRepository.save(contact);
		System.out.println("");

	}

}
