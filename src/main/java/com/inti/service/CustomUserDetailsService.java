package com.inti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inti.model.Utilisateur;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UtilisateurServiceImpl usi;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utilisateur u = usi.findByUsernameOrEmail(username);
		
		if(u == null)
		{
			throw new UsernameNotFoundException("L'utilisateur avec l'username " + username + " n'existe pas en BDD");
		}
		
		return User
				.withUsername(u.getUsername())
				.password(u.getMdp())
				.roles(u.getRole().getNom())
				.build();
	}

}
