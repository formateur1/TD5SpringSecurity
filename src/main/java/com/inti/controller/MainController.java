package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Role;
import com.inti.model.Utilisateur;
import com.inti.repository.IUtilisateurRepository;

@Controller
public class MainController {
	
	@Autowired
	IUtilisateurRepository iur;
	
	@GetMapping("hello")
	public String hello()
	{
		return "hello";
	}
	
	@GetMapping("login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("inscription")
	public String inscription()
	{
		return "inscription";
	}
	
	@PostMapping("inscription")
	public String inscription(@ModelAttribute("utilisateur") Utilisateur u)
	{
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		u.setMdp(b.encode(u.getMdp()));
		
		Role r = new Role("USER");
		u.setRole(r);
		
		iur.save(u);
		
		return "redirect:/login";
	}
	

}
