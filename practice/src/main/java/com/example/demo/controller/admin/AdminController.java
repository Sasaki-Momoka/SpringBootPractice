package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.contact.Contact;
import com.example.demo.service.contact.ContactService;

@Controller
public class AdminController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/admin/contacts")
	public String showList(Model model) {

		List<Contact> list = contactService.getContactlist();

		model.addAttribute("list", list);

		return "contactList";

	}
	
	@DeleteMapping
	("/admin/contacts/delate/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		System.out.println("テストcontroller");
		contactService.deleteById(id);
		System.out.println("テストcontroller");
	return  "redirect:/admin/contacts/";
	}
	
	@GetMapping("/admin/contacts/{id}")
	public String detailContact(@PathVariable("id") Long id,Model model) {

		Contact detail = contactService.getDetailById(id).orElse(null);

		model.addAttribute("detail", detail);

		return "contactDetail";

	}
	

}
