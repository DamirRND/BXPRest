package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.RobaGrupa;
import com.bx.Repository.RobaGrupaRepository;

@Service
public class RobaGrupaService {

	
	private final RobaGrupaRepository rgRep;
	
	@Autowired
	public RobaGrupaService(RobaGrupaRepository rgRep) {
		this.rgRep = rgRep;
	}
	
	
	public List<RobaGrupa> findAll(){
		return (List<RobaGrupa>) rgRep.findAll();
	}

	 public RobaGrupa save(RobaGrupa r){
		return rgRep.saveAndFlush(r);
	}
		 
	 public void delete(RobaGrupa r){
		 rgRep.delete(r);
	}
		 
	
	public RobaGrupa findOne(Integer id){
		 return rgRep.findOne(id);
	}
	
}
