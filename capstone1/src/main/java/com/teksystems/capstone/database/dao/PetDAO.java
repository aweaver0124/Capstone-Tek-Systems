package com.teksystems.capstone.database.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teksystems.capstone.database.entity.Pet;
import com.teksystems.capstone.database.entity.Vaccination;


public interface PetDAO extends JpaRepository<Pet, Long> {
	
	
	@Query("SELECT p FROM Pet p WHERE p.user.id = :userId")
	public List<Pet> findByUserId(Integer userId);
	
	public Pet findById(Integer id);
	
	@Query(value = "DELETE FROM pets WHERE id = :id", nativeQuery = true)
	public void deletePetById(Integer id);

}
