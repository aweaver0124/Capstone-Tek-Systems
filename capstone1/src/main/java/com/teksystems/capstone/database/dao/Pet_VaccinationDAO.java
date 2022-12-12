package com.teksystems.capstone.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teksystems.capstone.database.entity.Pet_Vaccination;

public interface Pet_VaccinationDAO extends JpaRepository<Pet_Vaccination, Long> {
	
	public List<Pet_Vaccination> findByPetId(Integer id);
	
}
