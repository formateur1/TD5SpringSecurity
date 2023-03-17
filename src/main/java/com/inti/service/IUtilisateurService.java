package com.inti.service;

import com.inti.model.Utilisateur;

public interface IUtilisateurService {
	
	public Utilisateur findByUsernameOrEmail(String usernameOrEmail);


}
