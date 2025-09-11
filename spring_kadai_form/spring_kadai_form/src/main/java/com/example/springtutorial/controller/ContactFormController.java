package com.example.springtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springtutorial.form.ContactForm;

@Controller
public class ContactFormController {
	
	@GetMapping("/form")
	public String showForm(@ModelAttribute("contactForm") ContactForm contactForm) {
	    return "contactFormView";
	}


	@PostMapping("/confirm")
	public String confirm(@Validated @ModelAttribute("contactForm") ContactForm form, BindingResult result) {
	    if (result.hasErrors()) {
	        return "contactFormView"; // ← リダイレクトせずに直接フォームを表示
	    }

	    return "confirmView";
	}


	    
	    @GetMapping("/confirm")
	    public String showConfirm(ContactForm contactForm, Model model) {
	        model.addAttribute("contactForm", contactForm);
	        return "confirmView";
	    }
	    
	    


}
