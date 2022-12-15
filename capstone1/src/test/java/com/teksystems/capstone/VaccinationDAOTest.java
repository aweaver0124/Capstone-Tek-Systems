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

import com.teksystems.capstone.database.dao.VaccinationDAO;
import com.teksystems.capstone.database.entity.Vaccination;


@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class VaccinationDAOTest {
	
	@Autowired
	VaccinationDAO vaxDao;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	
	public void returnVaccinationList() {
		List<Vaccination> vaccines = vaxDao.finbByVaccinesIdGreaterThanZero();
		Assertions.assertThat(vaccines.size()).isGreaterThan(0);
	}
	
	public void getVaccinationByNameTest(Integer id) {
		Vaccination vax = vaxDao.findById(id);
		Assertions.assertThat(vax.getName()).isEqualTo("Bordetella Bronchiseptica Vaccine");
	}
}
