package com.lym.dao.test2;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lym.entity.test2.Data;

public interface DataJpaDao extends JpaRepository<Data, Serializable> {

    @Query(value = "select * from data d where d.datatype=?1 and d.group_id=?2", nativeQuery = true)  
    List<Data> getDataByTypeAndGroup(int dataType, int groupId); 
    
}
