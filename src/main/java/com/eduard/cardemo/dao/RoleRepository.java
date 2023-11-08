package com.eduard.cardemo.dao;


import com.eduard.cardemo.entity.Make;
import com.eduard.cardemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByName(String theRoleName);
	
}
