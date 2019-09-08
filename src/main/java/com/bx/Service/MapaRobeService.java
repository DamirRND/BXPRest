package com.bx.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.Model.MapaRobe;
import com.bx.Repository.MapaRobeRepository;


@Service
public class MapaRobeService {
	
	
	private final MapaRobeRepository mpRepository;
	
	
	@Autowired
	public MapaRobeService(MapaRobeRepository mpRepository)
	{
		this.mpRepository=mpRepository;
		
	}
	
	public MapaRobe findOne(int sifra,String naziv, int vp)
	{
		return mpRepository.findOneByRobaSifraExtAndRobaNazivExtAndVpid(sifra, naziv, vp);
	}

}
