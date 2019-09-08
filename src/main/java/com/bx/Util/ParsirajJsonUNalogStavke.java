package com.bx.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bx.Model.Nalog;
import com.bx.Model.NalogStavka;
import com.bx.Model.NalogStavkaEksterno;

@Component
public class ParsirajJsonUNalogStavke {
	
	
	public List<NalogStavka> listaParsirana(List<NalogStavkaEksterno> lista, Nalog nalog){
		List<NalogStavka> listaN = new ArrayList<NalogStavka>();
		
		for (NalogStavkaEksterno nalogStEkst : lista) {
			NalogStavka nalogS = new NalogStavka();
			nalogS.setCena(Double.parseDouble(nalogStEkst.getVrednost()));
			nalogS.setKolicina(Double.parseDouble(nalogStEkst.getKolicina()));
			
			nalogS.setKupacSifraExt(Integer.parseInt(nalogStEkst.getKupacsifraext()));
			nalogS.setKupacNazivExt(nalogStEkst.getKupacnazivext());
			nalogS.setRobaSifraExt(Integer.parseInt(nalogStEkst.getRobasifraext()));
			nalogS.setRobaNazivExt(nalogStEkst.getRobanazivext());
			nalogS.setCena(Double.parseDouble(nalogStEkst.getVrednost())/Double.parseDouble(nalogStEkst.getKolicina()));
			nalogS.setNalog(nalog);
			listaN.add(nalogS);
		}
		
		
		
		return listaN;
		
	}

}
