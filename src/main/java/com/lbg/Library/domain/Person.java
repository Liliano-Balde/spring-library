package com.lbg.Library.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//person class for library, added entity, id, generatedvalue, jsonbackreference and manytoone annotations, item attributes, getters and setters, tostring

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String location;

	@JsonManagedReference
	@OneToMany(mappedBy = "person")
	private List<Item> items;

	public Person() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", location=" + location + "]";
	}

}
