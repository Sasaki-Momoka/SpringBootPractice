package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.admin.AdminEntity;
import com.example.demo.entity.contact.Contact;
import com.example.demo.form.admin.AdminForm;
import com.example.demo.form.contact.ContactForm;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.contact.ContactService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession; 

@Controller
public class AdminController {

	//private static final String request = null;
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/admin/contacts")
	public String showList(Model model) {
		List<Contact> list = contactService.getContactlist();
		model.addAttribute("list", list);
		return "contactList";
	}

	@GetMapping("/admin/contacts/{id}")
	public String detailContact(@PathVariable("id") Long id, Model model) {
		Contact detail = contactService.getDetailById(id).orElse(null);
		model.addAttribute("detail", detail);
		return "contactDetail";
	}

	@DeleteMapping("/admin/contacts/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		contactService.deleteById(id);
		redirectAttributes.addFlashAttribute("successMessage", "削除しました");
		return "redirect:/admin/contacts";
	}

	@GetMapping("/admin/contacts/{id}/edit")
	public String contactEdit(@PathVariable Long id, Model model) {
		model.addAttribute("contactForm", contactService.getEditById(id));
		return "contactEdit";
	}

	@PutMapping("/admin/contacts/{id}/edit")
	public String updateEdit(@Validated @ModelAttribute("contactForm") ContactForm contactForm, @PathVariable Long id,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		contactForm.setId(id);
		contactService.saveContact(contactForm);
		redirectAttributes.addFlashAttribute("successMessage", "保存しました");
		return "redirect:/admin/contacts";
	}
	
	
	@GetMapping("/admin/signup")
	public String showSignupForm(HttpSession session,Model model) {
		System.out.println("テストです。");
		model.addAttribute("user", new AdminEntity());
		return "signup";
}
	@PostMapping("/admin/signup")
	public String signup(@Validated @ModelAttribute("user")AdminForm user,BindingResult bindingResult ,HttpServletRequest request
			) {System.out.println("テストです。２");
		//  セッション情報を取得・生成
		//  有効なセッションがまだ存在しない場合、新しくセッションを生成して返す
		HttpSession session = request.getSession();
		//session.setAttribute(request, session);
		
		//  管理画面用のデータをadminFormから取り出す処理
		AdminForm adminForm = (AdminForm) session.getAttribute("adminForm");
		
		// adminFormで入力されたデータをcontactServiceが持っているsaveContactメソッドに渡してデータベースへ保存 → adminServiceへ繋げるように変えなければでは？
		adminService.saveAdmin(adminForm);
		//adminService.saveUser(adminForm);
		//adminService.save(adminForm);
		
		//  もし結果にエラーがある場合、サインアップ画面に戻してください　成功した時はお問い合わせ一覧画面に移動してください
		//  BindingResult → Springbootに入っているBindingResult型の変数
		//  bindingResultが持っている(.)hasErrorsメソッド(こちらもSpringbootで提供されている 戻り値がtrueかfalse
		if (bindingResult.hasErrors()) {
			System.out.println("テストです。３");
			return "/admin/signup";
		}
		
		return "redirect:/admin/contacts";
	}
	

}