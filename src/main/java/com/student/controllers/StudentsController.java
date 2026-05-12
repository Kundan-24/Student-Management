package com.student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.student.entities.Students;
import com.student.services.impl.StudentServiceImpl;

@Controller
public class StudentsController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@GetMapping("/students/add")
	public String showAddStudent(Model model) {
		model.addAttribute("student",new Students());
		return "addStudent";
	}
	
	@PostMapping("/students/add")
	public String saveStudent(@ModelAttribute("student") Students student,RedirectAttributes redirectAttributes) {
		studentServiceImpl.saveStudent(student);
		redirectAttributes.addFlashAttribute("success", "successfully added");
		return "redirect:/students/add";		
	}
	
	@GetMapping("/students/home")
	public String showAllStudents(Model model) {
		model.addAttribute("students", studentServiceImpl.getAllStudents());
		return "index";
	}
	
	@GetMapping("/student/update/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		Students student = studentServiceImpl.getStudentById(id);
		model.addAttribute("student", student);
		return "edit_student";
	}
	
	@PostMapping("student/update")
	public String updateStudent(@ModelAttribute("student") Students student, RedirectAttributes redirectAttributes) {
		
		try {
			studentServiceImpl.updateStudent(student.getId(), student);
			redirectAttributes.addFlashAttribute("success", "updated successfully");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "something wrong!!!");
		}
		
		return "redirect:/students/home";
	}
	
	
	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		try {
			studentServiceImpl.deleteStudent(id);
			redirectAttributes.addFlashAttribute("success", "Deleted successfully");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Not deleted");
		}
		
		return "redirect:/students/home";
	}
	
	
}
