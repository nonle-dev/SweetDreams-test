package com.sweetdreams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sweetdreams.dao.UserDAO;
import com.sweetdreams.models.User;


@Controller
public class UserController {
	@GetMapping("/register")
     public String addOrEdit(ModelMap model) {
		User u = new User();
//		u.setUsername("NamNV");
		model.addAttribute("USER",u);
		model.addAttribute("ACTION","saveOrUpdate");
    	 return "register";
     }
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model,@ModelAttribute("USER") User user ) {
		UserDAO dao = new UserDAO();
		dao.save(user);
		System.out.println("size :" +dao.getAll().size());
		return "register";
	}
	
	
	 @RequestMapping("list")
	 public String list(ModelMap model) {
		 UserDAO dao = new UserDAO();
		 model.addAttribute("USER",dao.getAll());
		 return "view-user";
	 }
	 
	 // khi bấm edit truyền vào username
	 @RequestMapping("/edit/{username}")
	 public String edit(ModelMap model,@PathVariable(name="username") String username) {
		 UserDAO dao = new UserDAO();
		 //tìm username trong list u 
		 User u = dao.findByUsername(username);
		 model.addAttribute("USER",u);
		 model.addAttribute("ACTION","/saveOrUpdate");
		 return "register";
	 }
	 
	// khi bấm edit truyền vào username
		 @RequestMapping("/delete/{username}")
		 public String delete(ModelMap model,@PathVariable(name="username") String username) {
			 UserDAO dao = new UserDAO();
			 dao.delete(username);
			 //xóa xong get lại dữ liệu
			 model.addAttribute("USER",dao.getAll());
			 return "view-user";
		 }
}
