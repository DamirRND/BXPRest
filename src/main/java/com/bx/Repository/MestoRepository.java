package com.bx.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bx.Model.Mesto;

public interface MestoRepository extends JpaRepository<Mesto, Integer>{

}
