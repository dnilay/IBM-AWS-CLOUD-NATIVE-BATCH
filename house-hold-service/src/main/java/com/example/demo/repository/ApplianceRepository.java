package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ApplianceEntity;


public interface ApplianceRepository extends JpaRepository<ApplianceEntity,Integer>{

    @Query("SELECT details FROM ApplianceEntity details WHERE details.brand=?1")
    List<ApplianceEntity> findByApplianceName(String name);
    
}
