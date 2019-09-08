package com.bx.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bx.Model.Radnik;

public interface RadnikRepository extends JpaRepository<Radnik, Integer>{

	Radnik findOneByKorImeAndKorLozinka(String korime, String korlozinka);
}
