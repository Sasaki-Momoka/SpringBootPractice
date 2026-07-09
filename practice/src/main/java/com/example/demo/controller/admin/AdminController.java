package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/admin/contacts/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		contactService.deleteById(id);
		redirectAttributes.addFlashAttribute("successMessage","削除しました");
	return  "redirect:/admin/contacts";
	}
	
	@DeleteMapping("/admin/contacts/{id}")
	public String detailContact(@PathVariable("id") Long id,Model model) {

		Contact detail = contactService.getDetailById(id).orElse(null);

		model.addAttribute("detail", detail);

		return "contactDetail";

	}

	
		@GetMapping("/admin/contacts/{id}/edit")
		public String contactEdit(@PathVariable Long id, Model model) {
			Contact edit = contactService.getEditById(id);
		    
		    model.addAttribute("edit", edit);
		    return "contactEdit";
		}
		
		@PostMapping("/admin/contacts/{id}/edit")
		public String upDateForm(@ModelAttribute @Validated edit,
				BindingResult bindingResult) {
			
			
			if(bindingResult.hasErrors()) {
			return "edit";
			}
			
			contactService.contactEdit(contactEdit);
			return "/admin/contacts";
			
			
		
	
}


	
	
	
	/*	@GetMapping("/admin/contacts/{id}/edit")
		public String Edit(@PathVariable("id") Long id, Model model) {
			EditForm form = contactService.getEditById(id);
			model.addAttribute("edit",edit);
			return "contactEdit";
		}
	
		@PostMapping("/admin/contacts/{id}/edit")
		public String upDateEdit(@PathVariable Long id, @ModelAttribute Edit edit) {
			contactService.save(edit);
			return "/admin/contacts";
		}*/
	

