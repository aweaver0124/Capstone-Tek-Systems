package com.teksystems.capstone.database.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="pets")
public class Pet {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "species")
	private String species;
	
	// File or String?
	@Column(name = "image")
	private String image;

	@Column (name = "breed")
	private String breed;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "personality")
	private String personality;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private User user;
	
	@ManyToMany
	@JoinTable(
	  name = "pets_vaccinations", 
	  joinColumns = @JoinColumn(name = "pet_id"), 
	  inverseJoinColumns = @JoinColumn(name = "vaccination_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude

	List<Vaccination> vaccinations;

	public Pet(String name) {
		super();
		this.name = name;
	}

	
	
}
