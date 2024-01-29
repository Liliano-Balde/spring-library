package com.lbg.Library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.Library.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
