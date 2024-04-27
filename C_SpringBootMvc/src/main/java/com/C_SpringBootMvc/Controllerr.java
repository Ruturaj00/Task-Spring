package com.C_SpringBootMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.C_SpringBootMvc.Model.*;
import com.C_SpringBootMvc.Service.Servicei;

@Controller
public class Controllerr {
	@Autowired
	Servicei service;
	
	@RequestMapping("/")
	public String preLogin() {
		return "Login";
	}
	
	@RequestMapping("/Login")
	public String Sucess(@RequestParam String username,@RequestParam String password,Model m) {
		List<Student> ls = service.LoginStudent(username,password);
		if(!ls.isEmpty()) {
			m.addAttribute("data",ls);
			System.out.println("Entry exist");
			//return this.pagging(0,m);
			return "Sucess";
		}
		
		 
		return "Login";
	}
	
	@RequestMapping("/delete")
	public String deleteByname(@RequestParam String name,Model m) {
		service.deletByname(name);
		List<Student>ls = service.getAll();
		m.addAttribute("data",ls);
		return "Sucess";
	}
	
	@RequestMapping("/edit")
	public String editStudent(@RequestParam int rollno,Model m) {
		Student s = service.Edit(rollno);
		m.addAttribute("student",s);
		return "edit";
	}
	
	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Student s,Model m) {
		List<Student> list = service.UpdateStudent(s);
		m.addAttribute("data",list);
		return "Sucess";
	}
	
	
	@RequestMapping("/paging")
	public String pagging(@RequestParam int pageNo,Model m) {
	    List<Student> list = service.paging(pageNo, 3);
	    m.addAttribute("data",list);
	    return "Sucess";
	}

	
	@RequestMapping("/Register")
	public String preRegister()
	{
		return "Register";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Student student) {
		service.save(student);
		
		return "Login";
	}
	
	@RequestMapping("/Sucess")
	public String sucess() {
		return "Sucess";
	}
	
}
