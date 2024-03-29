package com.bx.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bx.Model.Komitent;
import com.bx.Model.Nalog;
import com.bx.Model.NalogStavka;
import com.bx.Model.Roba;

@SuppressWarnings("rawtypes")
public interface NalogStavkaRepository extends JpaRepository<NalogStavka, Integer>, JpaSpecificationExecutor{

	List<NalogStavka> findAllByKupacIdAndKupacSifraExt(int id, int sifra);
	List<NalogStavka> findAllByNalogId(Integer id);
	
	List<NalogStavka> findAllByKupac(Komitent k);
	List<NalogStavka> findAllByKupacAndRoba(Komitent k, Roba r);
	List<NalogStavka> findAllByRoba(Roba r);
	
	List<NalogStavka> findAllByKupacAndNalog(Komitent k, Nalog n);
	List<NalogStavka> findAllByRobaAndNalog(Roba r, Nalog n);
	List<NalogStavka> findAllByKupacAndRobaAndNalog(Komitent k, Roba r, Nalog n);
	
	List<NalogStavka> findAllByNalog(Nalog n);
	
	
	@Transactional
	@Query("select c from NalogStavka c where c.nalog=:nalog and c.kupac is null and c.roba is null")
	List<NalogStavka> listaNeobradjenih(@Param("nalog") Nalog n);
	
	@Transactional
	@Query("select c from NalogStavka c where c.nalog=:nalog and c.kupac is not null and c.roba is not null")
	List<NalogStavka> listaObradjenih(@Param("nalog") Nalog n);
	
	
	@Transactional
	@Modifying
	@Query(value="update nalogst s set kupac_id = x.kupac_id\r\n" + 
			"from nalog n\r\n" + 
			"join mapa_kupca x on x.vp_id = n.komitent_id \r\n" + 
			"where s.kupac_id is null and n.id = s.nalog_id\r\n" + 
			"and (coalesce(s.kupacsifraext, -1) = x.kupacsifraext OR s.kupacnazivext = x.kupacnazivext ) and s.nalog_id=:id", nativeQuery = true)
    public int mapirajKupce(@Param("id") int id);
	
	@Transactional
	@Modifying
	@Query("DELETE from NalogStavka s WHERE s.nalog=:nalog")
    public void izbrisiSveStavke(@Param("nalog") Nalog n);
	
	
	@Transactional
	@Modifying
	@Query(value="update nalogst s set roba_id = x.roba_id\r\n" + 
			"from nalog n\r\n" + 
			"join mapa_robe x on x.vp_id = n.komitent_id \r\n" + 
			"where s.roba_id is null and n.id = s.nalog_id\r\n" + 
			"and (coalesce(s.robasifraext, -1) = x.robasifraext OR s.robanazivext = x.robanazivext ) and s.nalog_id=:id", nativeQuery=true)
	public int mapirajRobu(@Param("id") int id);
}
