package com.lbg.Library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.Library.domain.Item;
import com.lbg.Library.repo.ItemRepo;

//Service class for managing library items.
//Implemented methods for creating, retrieving, updating, deleting items and checking in items.

@Service
public class ItemService {

	private ItemRepo repo;

	public ItemService(ItemRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Item> createItem(Item newItem) {
		Item created = this.repo.save(newItem);
		newItem.setCheckedin(true);
		return new ResponseEntity<Item>(created, HttpStatus.CREATED);
	}

	public List<Item> getItem() {
		return this.repo.findAll();
	}

//	public ResponseEntity<Item> checkItem(int id) {
//		Optional<Item> found = this.repo.findById(id);
//		if (found.isEmpty()) {
//			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
//	}
//		Item body = found.get();
//		
//		body.setCheckedin(false); 
//			}
//		}

	public ResponseEntity<Item> getItem(int id) {
		Optional<Item> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}

		Item body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deleteItem(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public String deleteItems() {
		this.repo.deleteAll();
		return repo.toString();
	}

	public ResponseEntity<Item> updateItem(int id, Item newItem) {

		Optional<Item> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Item existing = found.get();

		if (newItem.getName() != null) {
			existing.setName(newItem.getName());
		}
		if (newItem.getAuthor() != null) {
			existing.setAuthor(newItem.getAuthor());

		}
		if (newItem.getPerson() != null) {
			existing.setPerson(newItem.getPerson());

		}
		Item updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

	public ResponseEntity<Item> checkItem(int id) {
		Optional<Item> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Item item = found.get();

//		if (!item.isCheckedin()) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		}
		item.setCheckedin(true);
		Item updated = this.repo.save(item);

		return ResponseEntity.ok(updated);
	}

}
