package com.bx.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bx.Model.Komitent;

public interface KomitentRepository extends JpaRepository<Komitent, Integer>{

	List<Komitent> findAllByTipStartsWithIgnoreCase(String tip);
	
}
