package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.Entitet;
import com.bx.Repository.EntitetRepository;


@Service
public class EntitetService {

	private final EntitetRepository erep;
	
	@Autowired
	public EntitetService(EntitetRepository erep) {
		this.erep =erep;
	}
	
	
	public List<Entitet> findAll(){
		return (List<Entitet>) erep.findAll();
	}
	
	 public Entitet findOne(Integer id){
		 return erep.findOne(id);
	 }
	 
	 public Entitet save(Entitet r){
		return erep.saveAndFlush(r);
	 }
	 
	 public void delete(Entitet r){
		 erep.delete(r);
	 }
	
	
}
