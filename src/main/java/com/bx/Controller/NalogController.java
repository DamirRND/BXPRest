package com.bx.Controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bx.Model.Nalog;
import com.bx.Model.NalogStavka;
import com.bx.Model.NalogStavkaEksterno;
import com.bx.Service.NalogService;
import com.bx.Service.NalogStavkaService;
import com.bx.Util.ParsirajJsonUNalogStavke;

@Controller
@RequestMapping(value="/nalogController")
public class NalogController {
	
	NalogService ns;
	NalogStavkaService nss;
	ParsirajJsonUNalogStavke pjn;
	
	@Autowired
	public NalogController(NalogService ns,NalogStavkaService nss,ParsirajJsonUNalogStavke pjn) {
		this.ns = ns;
		this.nss = nss;
		this.pjn = pjn;
	}

	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/kreirajNalog", method=RequestMethod.POST)
	@ResponseBody
	public int kreirajNalog(@RequestParam("json") String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Nalog nalog = mapper.readValue(json, new TypeReference<Nalog>() {});
		if(nalog!=null) {
			ns.save(nalog);
			return ns.pronadjiMax(nalog.getDatum(), nalog.getMesec(), nalog.getKomitent(), 2);
		}else {
			return 0;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/ucitajExcel", method=RequestMethod.POST)
	@ResponseBody
	public int ucitajExcel(@RequestParam("json") String json, @RequestParam("nalogid") String nalogid) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<NalogStavkaEksterno> stavkeEksterno = mapper.readValue(json, new TypeReference<List<NalogStavkaEksterno>>() {});
		Nalog nalog = ns.findOne(Integer.parseInt(nalogid));
		if(stavkeEksterno!=null) {
			List<NalogStavka> listaZaInsert = pjn.listaParsirana(stavkeEksterno, nalog);
			for (NalogStavka nalogSt : listaZaInsert) {
				nss.save(nalogSt);
			}
			return 1;
		}else {
			return 0;
		}
	}
}
