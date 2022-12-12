package com.teksystems.capstone.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teksystems.capstone.database.entity.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
	
	public List<UserRole> findByUserId(Integer userId);
	

}
