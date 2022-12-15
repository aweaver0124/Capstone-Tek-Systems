package com.teksystems.capstone;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.entity.User;




@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class UserDAOTest {

	@Autowired
	UserDAO userDao;
	
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void createUserTest() {
		User user = new User();
		Assertions.assertThat(user.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void testFindByUsername() {
		User user = new User();
		user.setFirstName("Patty");
		user.setLastName("Smith");
		user.setUsername("psmith");
		user.setState("Colorado");
		user.setPassword("password");
		
		Assertions.assertThat(userDao.findByUsername("psmith")).isEqualTo(user);
	}
}
