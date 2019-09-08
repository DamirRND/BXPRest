package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.Region;
import com.bx.Repository.RegionRepository;


@Service
public class RegionService {

	
	private final RegionRepository rrep;
	
	
	@Autowired
	public RegionService(RegionRepository rrep) {
		this.rrep = rrep;
	}
	
	public List<Region> findAll(){
		return (List<Region>) rrep.findAll();
	}
	
	 public Region findOne(Integer id){
		 return rrep.findOne(id);
	 }
	 
	 public Region save(Region r){
		return rrep.saveAndFlush(r);
	 }
	 
	 public void delete(Region r){
		 rrep.delete(r);
	 }
	
	 
	 public void deleteById(int id) {
		 rrep.deleteById(id);
	 }
}
