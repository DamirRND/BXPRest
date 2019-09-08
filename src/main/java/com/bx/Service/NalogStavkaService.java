package com.bx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.Komitent;
import com.bx.Model.Nalog;
import com.bx.Model.NalogStavka;
import com.bx.Model.Roba;
import com.bx.Repository.NalogStavkaRepository;

@Service
public class NalogStavkaService {

	
	private final NalogStavkaRepository nlgrep;
	
	@Autowired
	public NalogStavkaService(NalogStavkaRepository nlgrep) {
		this.nlgrep = nlgrep;
	}
	 
	public List<NalogStavka> findSveCustom(int id, int sifra){
		return (List<NalogStavka>) nlgrep.findAllByKupacIdAndKupacSifraExt(id, sifra);
	}

	public List<NalogStavka> findAllByKupac(Komitent k){
		return nlgrep.findAllByKupac(k);
	}
	
	public List<NalogStavka> findAllByRoba(Roba r){
		return nlgrep.findAllByRoba(r);
	}

	public List<NalogStavka> findAllByKupacAndRoba(Komitent k, Roba r){
		return nlgrep.findAllByKupacAndRoba(k, r);
	}
	
	public List<NalogStavka> findallByKupacAndNalog(Komitent k, Nalog n){
		return nlgrep.findAllByKupacAndNalog(k, n);
	}
	
	public List<NalogStavka> findallByRobaAndNalog(Roba r, Nalog n){
		return nlgrep.findAllByRobaAndNalog(r, n);
	}
	
	public List<NalogStavka> findallByKupacAndRobaAndNalog(Komitent k, Roba r, Nalog n){
		return nlgrep.findAllByKupacAndRobaAndNalog(k, r, n);
	}
	
	public List<NalogStavka> findallByNalog(Nalog n){
		return nlgrep.findAllByNalog(n);
	}
	
	public List<NalogStavka> findallByNalogId(Integer id){
		return nlgrep.findAllByNalogId(id);
	}
	
	public NalogStavka findOne(int id) {
		return nlgrep.findOne(id);
	}
	public int mapirajKupca(int id) {
		return nlgrep.mapirajKupce(id);
	}
	
	public int mapirajRobu(int id) {
		return nlgrep.mapirajRobu(id);
	}
	

	public void izbrisiSveStavke(Nalog n) {
		nlgrep.izbrisiSveStavke(n);
	}


	public List<NalogStavka> findSveNeobradjene(Nalog n){
		return (List<NalogStavka>) nlgrep.listaNeobradjenih(n);
	}
	
	public List<NalogStavka> findSveObradjene(Nalog n){
		return (List<NalogStavka>) nlgrep.listaObradjenih(n);
	}

	public NalogStavka save(NalogStavka n )
	{
		return nlgrep.saveAndFlush(n);
	}
	
}
