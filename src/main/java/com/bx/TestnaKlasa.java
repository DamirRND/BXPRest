package com.bx;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import com.bx.Model.Entitet;

public class TestnaKlasa {
	
	
	public static void main(String[] args) throws Exception {
		Entitet entitet = new Entitet();
		entitet.setId(1);
		entitet.setNaziv("Proba");
		entitet.setSifra(1234);
		
		ObjectMapper mapper = new ObjectMapper();
		JSONObject json = new JSONObject();
		
		json.put("id", 1);
		json.put("sifra", 54321);
		
		
		Entitet novi = mapper.readerForUpdating(entitet).readValue(json.toJSONString());
		
		System.out.println(novi.getId());
		System.out.println(novi.getNaziv());
		System.out.println(novi.getSifra());
	}

}
