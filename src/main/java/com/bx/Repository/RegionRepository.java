package com.bx.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bx.Model.Region;

public interface RegionRepository extends JpaRepository<Region, Integer>{

	@Transactional
    Long deleteById(int id);
}
