package com.bx.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.Komitent;
import com.bx.Model.Nalog;
import com.bx.Repository.NalogRepository;


@Service
public class NalogService {

	
	private final NalogRepository nrep;
	
	
	
	@Autowired
	public NalogService(NalogRepository nrep) {
		this.nrep = nrep;
	}
	
	public List<Nalog> findAll(){
		return (List<Nalog>) nrep.findAll();
	}
	
	public Nalog findOneNalog(int id, int status, LocalDate datum, int mesec, Komitent k) {
		return nrep.findOneByIdAndStatusAndDatumAndMesecAndKomitent(id, status, datum, mesec, k);
	}
	
	public Nalog provjeraNaloga(LocalDate datum, int mesec,Komitent id, int status) {
		return nrep.findOneByDatumAndMesecAndStatusNotEqual(datum, mesec, id,status);
	}
	
	public Nalog findOne(Integer id){
		 return nrep.findOne(id);
	 }
	 
	 public Nalog save(Nalog r){
		return nrep.saveAndFlush(r);
	 }
	 
	 public void delete(Nalog r){
		 nrep.delete(r);
	 }
	 
	 public Nalog findZaExport(LocalDate datum, int mesec, Komitent k) {
		 return nrep.findOneByDatumAndMesecAndKomitent(datum, mesec, k);
	 }
	 
	 public Nalog findOneByFajl(String name) {
		 return nrep.findOneByIzvorniFajl(name);
	 }
	 
	 public List<Nalog> findSve(int status){
		 return (List<Nalog>) nrep.findAllOtvorene(status);
	 }
	 
	 
	public int pronadjiMax(LocalDate datum,int mesec,Komitent id, int status ) {
		return nrep.getMaxId(datum, mesec, id, status);
	}
	
	
}
