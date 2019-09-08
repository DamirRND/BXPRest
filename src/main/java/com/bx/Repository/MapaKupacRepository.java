package com.bx.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bx.Model.MapaKupca;



public interface MapaKupacRepository extends JpaRepository<MapaKupca, Integer>{
	
	MapaKupca findOneByKupacSifraExtAndKupacNazivExtAndVpid(int sifra,String naziv, int vp);

}
