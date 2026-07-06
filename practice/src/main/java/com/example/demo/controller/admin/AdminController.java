package com.example.demo.controller.admin;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

		return "contactList";

	}
	@PostMapping("/admin/contacts")
	public String date(
	    @RequestParam("datetime") 
	    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") LocalDateTime datetime) {
			return "contactList";
	   
	}
	

}
