package com.lbg.Library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

//item class for library, added entity, id, generatedvalue, jsonbackreference and manytoone annotations, item attributes, getters and setters, tostring

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String author;
	private boolean checkedin = true;

	@JsonBackReference
	@ManyToOne
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Item() {
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isCheckedin() {
		return checkedin;
	}

	public void setCheckedin(boolean checkedin) {
		this.checkedin = checkedin;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", author=" + author + ", checkedin=" + checkedin + "]";
	}

}
