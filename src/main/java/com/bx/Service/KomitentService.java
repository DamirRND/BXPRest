package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.Komitent;
import com.bx.Repository.KomitentRepository;

@Service
public class KomitentService {
	
	private final KomitentRepository krep;
	
	@Autowired
	public KomitentService(KomitentRepository krep) {
		this.krep = krep;
	}
	 public Integer count() {
	        return Math.toIntExact(krep.count());
	 }
	
	 public Komitent findOne(Integer id){
		 return krep.findOne(id);
	 }
	 
	 public Komitent save(Komitent r){
		return krep.saveAndFlush(r);
	 }
	 
	 public void delete(Komitent r){
		 krep.delete(r);
	 }
	 
	public List<Komitent> findZaList(){
		return (List<Komitent>) krep.findAll();
	}

	public List<Komitent> findAllByTip(String tip){
		return (List<Komitent>) krep.findAllByTipStartsWithIgnoreCase(tip);
	}

}
