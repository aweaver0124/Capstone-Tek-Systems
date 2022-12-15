package com.teksystems.capstone.database.dao;

//import java.util.List;
//import java.util.Map;
//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.teksystems.capstone.database.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>  {
	


	public User findByUsername(String username);
}
