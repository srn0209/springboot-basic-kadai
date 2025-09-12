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
    public String showForm(Model model) {
        // Flash属性にformがあれば使う、なければ新規作成
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        return "contactFormView";
    }

    @PostMapping("/confirm")
    public String confirm(@Validated @ModelAttribute("contactForm") ContactForm form,
                          BindingResult result,
                          RedirectAttributes redirectAttributes,
                          Model model) {
        if (result.hasErrors()) {
            // フォーム画面にリダイレクト（PRG）
            redirectAttributes.addFlashAttribute("contactForm", form);
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "contactForm", result);
            return "redirect:/form";
        }

        // エラーがなければ確認画面を表示（リダイレクトしない）
        model.addAttribute("contactForm", form);
        return "confirmView";
    }
}



