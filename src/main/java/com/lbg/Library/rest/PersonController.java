package com.lbg.Library.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.Library.domain.Person;
import com.lbg.Library.services.PersonService;

//REST controller for managing library people.
//created endpoints for creating, retrieving, updating, and deleting items.

@RestController
@RequestMapping("/person")
public class PersonController {

	private PersonService service;

	public PersonController(PersonService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person newPerson) {
		return this.service.createPerson(newPerson);
	}

	@GetMapping("/get")
	public List<Person> getPerson() {
		return this.service.getPerson();

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable int id) {
		return this.service.getPerson(id);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person newPerson) {
		return this.service.updatePerson(id, newPerson);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deletePerson(@PathVariable int id) {
		return this.service.deletePerson(id);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllPeople() {
		return ResponseEntity.ok(service.deletePeople());
	}
}
