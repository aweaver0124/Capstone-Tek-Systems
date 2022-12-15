package com.teksystems.capstone.database.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teksystems.capstone.database.entity.Vaccination;

@Repository
public interface VaccinationDAO extends JpaRepository<Vaccination, Long>  {
	
	@Query("SELECT v FROM Vaccination v WHERE id > 0")
	public List<Vaccination> finbByVaccinesIdGreaterThanZero();
	
	public Vaccination findByNameLike(String name);
	
	public Vaccination findById(Integer id);
	
	@Query(value = "SELECT v.name, pv.clinic_name AS 'clinicName', pv.date_received AS 'dateReceived', pv.expiration_date AS 'expirationDate' from vaccinations v "
			+ "inner join pets_vaccinations pv on pv.vaccination_id = v.id "
			+ "inner join pets p on pv.pet_id = p.id "
			+ "where p.id = :id", nativeQuery = true)
	List<Map<String,Object>> getPetVaccinations(Integer id);

}
