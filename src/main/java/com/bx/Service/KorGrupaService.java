package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.KorGrupa;
import com.bx.Repository.KorGrupaRepository;

@Service
public class KorGrupaService {

	private KorGrupaRepository korrep;
	
	@Autowired
	public KorGrupaService(KorGrupaRepository korrep) {
		this.korrep = korrep;
	}
	

	public List<KorGrupa> findAll() {
		return (List<KorGrupa>) korrep.findAll();
	}

	public KorGrupa findOne(Integer id){
		 return korrep.findOne(id);
	 }
	 
	 public KorGrupa save(KorGrupa r){
		return korrep.saveAndFlush(r);
	 }
	 
	 public void delete(KorGrupa r){
		 korrep.delete(r);
	 }
	
	
}
