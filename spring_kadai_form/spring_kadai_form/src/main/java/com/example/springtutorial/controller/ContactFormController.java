package com.example.springtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springtutorial.form.ContactForm;

@Controller
public class ContactFormController {
	
	 @GetMapping("/form")
	    public String showForm(ContactForm contactForm, Model model) {
		 model.addAttribute("contactForm", contactForm);
	        return "contactFormView";
	    }

	 @PostMapping("/confirm")
	 public String confirm(@Validated ContactForm form, BindingResult result, RedirectAttributes redirectAttributes) {
	     if (result.hasErrors()) {
	         // エラー内容を一時的に保持してリダイレクト
	         redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
	         redirectAttributes.addFlashAttribute("contactForm", form);
	         return "redirect:/contact"; // ← リダイレクトでフォームに戻す
	     }

	     return "contact/confirm"; // バリデーションOKなら確認画面へ
	 }

	    
	    @GetMapping("/confirm")
	    public String showConfirm(ContactForm contactForm, Model model) {
	        model.addAttribute("contactForm", contactForm);
	        return "confirmView";
	    }
	    
	    @GetMapping("/contact")
	    public String showForm1(@ModelAttribute("contactForm") ContactForm form, Model model) {
	        return "contact/form";
	    }


}
