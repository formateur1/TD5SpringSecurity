package com.inti.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	@NonNull
	@Column(unique = true, nullable = false)
	private String username;
	@NonNull
	@Column(nullable = false)
	private String mdp;
	@NonNull
	@Column(unique = true, nullable = false)
	private String email;
	private String tel;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_role")
	Role role;

}
