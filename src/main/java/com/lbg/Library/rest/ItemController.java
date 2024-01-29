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

import com.lbg.Library.domain.Item;
import com.lbg.Library.services.ItemService;

//REST controller for managing library items.
//created endpoints for creating, retrieving, updating, and deleting items.

@RestController
@RequestMapping("/item")
public class ItemController {

	private ItemService service;

	public ItemController(ItemService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Item> createItem(@RequestBody Item newItem) {
		return this.service.createItem(newItem);

	}

	@GetMapping("/get")
	public List<Item> getItem() {
		return this.service.getItem();

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Item> getItem(@PathVariable int id) {
		return this.service.getItem(id);

	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteItem(@PathVariable int id) {
		return this.service.deleteItem(id);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item newItem) {
		return this.service.updateItem(id, newItem);

	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllItems() {
		return ResponseEntity.ok(service.deleteItems());
	}
}
