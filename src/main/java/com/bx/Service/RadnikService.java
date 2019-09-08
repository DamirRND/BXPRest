package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.Radnik;
import com.bx.Repository.RadnikRepository;


@Service
public class RadnikService {

	
	private RadnikRepository radnikrep;
	
	
	@Autowired
	public RadnikService(RadnikRepository radnikrep) {
		this.radnikrep = radnikrep;
	}
	
	public Radnik findOne(String korime, String korlozinka) {
		return radnikrep.findOneByKorImeAndKorLozinka(korime, korlozinka);
	}
	
	public List<Radnik> findAll(){
		return (List<Radnik>) radnikrep.findAll();
	}

	
	 public Radnik findOne(Integer id){
		 return radnikrep.findOne(id);
	 }
	 
	 public Radnik save(Radnik r){
		return radnikrep.saveAndFlush(r);
	 }
	 
	 public void delete(Radnik r){
		 radnikrep.delete(r);
	 }
	
	
}
