package com.inti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Utilisateur;
import com.inti.repository.IUtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {
	
	@Autowired
	IUtilisateurRepository iur;

	@Override
	public Utilisateur findByUsernameOrEmail(String usernameOrEmail) {
		
		return iur.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
	}
	
	

}
