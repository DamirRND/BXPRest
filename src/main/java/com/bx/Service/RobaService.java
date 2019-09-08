package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.Roba;
import com.bx.Repository.RobaRepository;

@Service
public class RobaService {

	
	private final RobaRepository robarep;
	
	@Autowired
	public RobaService(RobaRepository robarep) {
		this.robarep = robarep;
	}
	
	 
	 public List<Roba> findAllCombo(){
		 return (List<Roba>) robarep.findAll();
	 }
	 
	 public Roba findOne(Integer id){
		 return robarep.findOne(id);
	 }
	 
	 public Roba save(Roba r){
		return robarep.saveAndFlush(r);
	 }
	 
	 public void delete(Roba r){
		robarep.delete(r);
	 }
	 
		
}
