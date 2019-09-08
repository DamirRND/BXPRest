package com.bx.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bx.Model.Radnik;
import com.bx.Service.RadnikService;

@Controller
@RequestMapping(value="/loginController")
public class LoginController {
	
	
	RadnikService rs;
	
	@Autowired
	public LoginController(RadnikService rs) {
		this.rs =rs;
	}
	
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public int login(@RequestParam("username") String username, @RequestParam("password") String password) {
		Radnik radnik = rs.findOne(username, password);
		
		if(radnik!=null) {
			return 1;
		}else {
			return 0;
		}
		
	}

}
