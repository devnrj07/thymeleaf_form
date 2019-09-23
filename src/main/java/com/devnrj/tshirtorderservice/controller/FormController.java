package com.devnrj.tshirtorderservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devnrj.tshirtorderservice.model.TShirt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FormController {

	@GetMapping("/order")
	public String fooForm(Model model) {
		model.addAttribute( "orderform", new TShirt());
		
		return "orderForm.html";
	}
	
	@ModelAttribute("multiCheckboxAllValues")
    public String[] getMultiCheckboxAllValues() {
        return new String[] {"Desgin 1", "Desgin 2", "Desgin 3", "Desgin 5"};	
	}
	
	@ModelAttribute("singleSelectAllValues")
    public String[] getSingleSelectAllValues() {
        return new String[] {"S", "M", "L", "XL","XXL"};
	}
	
	@ModelAttribute("dropSelectAllValues")
    public String[] getDropSelectAllValues() {
        return new String[] {"Online", "COD","Mess-Refund"};
	}
	
	@PostMapping("/order")
	public String orderPlace(
			@ModelAttribute("orderform") TShirt orderForm,
			// WARN: BindingResult *must* immediately follow the Command.
			// https://stackoverflow.com/a/29883178/1626026
			BindingResult bindingResult,   
			Model model,
			RedirectAttributes ra ) {
		
		log.debug("form submission.");
		
		if ( bindingResult.hasErrors() ) {
			return "orderForm";
		}

		ra.addFlashAttribute("orderform", orderForm);
		
		return "redirect:/orderConfirm";
	}
	
	@GetMapping("/orderConfirm")
	public String orderConfirm(
			@ModelAttribute("orderform") TShirt orderForm,
			Model model) {
		
		log.debug( "!!!" + orderForm.toString());
		
		return "orderConfirm";
	}
	
}
