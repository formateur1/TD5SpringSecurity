package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
