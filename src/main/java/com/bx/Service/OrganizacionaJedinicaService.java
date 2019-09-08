package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.OrganizacionaJedinica;
import com.bx.Repository.OrganizacionaJedinicaRep;

@Service
public class OrganizacionaJedinicaService {

	
	private final OrganizacionaJedinicaRep orgrep;
	
	
	@Autowired
	public OrganizacionaJedinicaService(OrganizacionaJedinicaRep orgrep) {
		this.orgrep = orgrep;
	}
	

	public List<OrganizacionaJedinica> findAll(){
		return (List<OrganizacionaJedinica>) orgrep.findAll();
	}

	
	 public OrganizacionaJedinica findOne(Integer id){
		 return orgrep.findOne(id);
	 }
	 
	 public OrganizacionaJedinica save(OrganizacionaJedinica r){
		return orgrep.saveAndFlush(r);
	 }
	 
	 public void delete(OrganizacionaJedinica r){
		 orgrep.delete(r);
	 }
	
}
