package com.student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.student.services.impl.StudentServiceImpl;

@Controller
public class LoginController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	private String email = "kundan@gmail.com";
	private String password = "1224";
	
	 @GetMapping("/admin")
	    public String showAdminLogin() {
	        return "adminLogin"; 
	    }
	
	@PostMapping("/admin")
	public String adminLoginHandler(@RequestParam("email") String email,@RequestParam("password") String password,RedirectAttributes redirectAttributes) {
		if(email.equals(this.email) && password.equals(this.password)) {
		return "redirect:/students/home";
		}else {
			redirectAttributes.addFlashAttribute("error", "Invalid Email or Password");
			return "redirect:/admin";
		}
	}

}
