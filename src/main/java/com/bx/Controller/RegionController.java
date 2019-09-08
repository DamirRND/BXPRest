package com.bx.Controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bx.Model.Region;
import com.bx.Service.RegionService;

@Controller
@RequestMapping(value="/regionController")
public class RegionController {
	
	RegionService  rs;
	
	public RegionController(RegionService rs) {
		this.rs = rs;
	}
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/ucitajSve", method=RequestMethod.POST)
	@ResponseBody
	public List<Region> ucitajSve() {
		return rs.findAll();
	}
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/sacuvajRegion", method=RequestMethod.POST)
	@ResponseBody
	public int sacuvaj(@RequestParam("json") String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Region region = mapper.readValue(json, new TypeReference<Region>() {});
		if(region!=null) {
			System.out.println("PRINTAM IZ JAVE " + region.getId());
			System.out.println("PRINTAM IZ JAVE " + region.getSifra());
			System.out.println("PRINTAM IZ JAVE " + region.getNaziv());
			System.out.println("PRINTAM IZ JAVE " + region.getEntitet().getId());
			return 1;
		}else {
			return 0;
		}
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/izbrisiRegion", method=RequestMethod.POST)
	@ResponseBody
	public void izbrisi(@RequestParam("id") int id) {
		rs.deleteById(id);
	}


}
