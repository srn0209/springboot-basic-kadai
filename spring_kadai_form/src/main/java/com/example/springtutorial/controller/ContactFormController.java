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
	public String showForm(@ModelAttribute("contactForm") ContactForm contactForm, Model model) {
	    // Flash属性から BindingResult を受け取って Model に追加
	    if (!model.containsAttribute(BindingResult.MODEL_KEY_PREFIX + "contactForm")) {
	        model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "contactForm",
	                           new org.springframework.validation.BeanPropertyBindingResult(contactForm, "contactForm"));
	    }
	    return "contactFormView";
	}

	@PostMapping("/form")
	public String submitForm(@Validated @ModelAttribute("contactForm") ContactForm form,
	                         BindingResult result,
	                         RedirectAttributes redirectAttributes) {
	    if (result.hasErrors()) {
	        return "contactFormView";
	    }

	    // 🔥 Flash属性でフォーム内容を渡す
	    redirectAttributes.addFlashAttribute("contactForm", form);
	    return "redirect:/confirm";
	}



	    
	    @GetMapping("/confirm")
	    public String showConfirm(ContactForm contactForm, Model model) {
	        model.addAttribute("contactForm", contactForm);
	        return "confirmView";
	    }
	    
	    


}
