package com.teksystems.capstone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.teksystems.capstone.database.dao.PetDAO;
import com.teksystems.capstone.database.entity.Pet;


@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class PetsDAOTest {
	
	@Autowired
	private PetDAO petDao;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void createNewPetTest() {
		Pet newPet =  new Pet("Fido");
		
		petDao.save(newPet);
		
		Assertions.assertThat(newPet.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void getPetTest() {
		Pet pet = petDao.findById(1);
		Assertions.assertThat(pet.getId()).isEqualTo(1);
	}
	
}
