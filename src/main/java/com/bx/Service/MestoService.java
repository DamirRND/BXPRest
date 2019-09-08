package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.Mesto;
import com.bx.Repository.MestoRepository;

@Service
public class MestoService {
	
	private final MestoRepository mrep;
	
	@Autowired
	public MestoService(MestoRepository mrep) {
		this.mrep = mrep;
	}

	public List<Mesto> listaJedan;
	
	public List<Mesto> findAll(){
		return (List<Mesto>) mrep.findAll();
 	}

	public Mesto findOne(Integer id){
		 return mrep.findOne(id);
	 }
	 
	 public Mesto save(Mesto r){
		return mrep.saveAndFlush(r);
	 }
	 
	 public void delete(Mesto r){
		 mrep.delete(r);
	 }
	
}
