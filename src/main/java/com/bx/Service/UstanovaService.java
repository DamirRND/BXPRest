package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.Ustanova;
import com.bx.Repository.UstanovaRepository;

@Service
public class UstanovaService {

	private final UstanovaRepository urep;
	
	
	@Autowired
	public UstanovaService(UstanovaRepository urep) {
		this.urep = urep;
	}
	
	 public Ustanova findOne(Integer id){
		 return urep.findOne(id);
	 }
	 
	 public Ustanova save(Ustanova r){
		return urep.saveAndFlush(r);
	 }
	 
	 public void delete(Ustanova r){
		 urep.delete(r);
	 }
	 
	 
	public List<Ustanova> findAllCombo(){
		return (List<Ustanova>) urep.findAll();
	}

	 
}
