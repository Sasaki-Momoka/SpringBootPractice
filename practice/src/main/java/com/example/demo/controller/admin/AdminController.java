package com.example.demo.controller.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.contact.Contact;
import com.example.demo.service.contact.ContactService;

@Controller
public class AdminController {
	
	@Autowired
	private ContactService contactService;

	@GetMapping("/admin/contacts")
	public String showList(Model model) {

		List<Contact> list = contactService.getContactlist();
		model.addAttribute("list",list);
		System.out.println("数2："+ list.toString());
			return "contactList";

	}

	

}
