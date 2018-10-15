package com.lym.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lym.entity.Service;

public interface ServiceJpaDao extends JpaRepository<Service, Serializable> {

    @Query(value = "select * from service s where s.owner_id=?1", nativeQuery = true)  
    List<Service> getServiceByOwnerId(String ownerId); 
    
}