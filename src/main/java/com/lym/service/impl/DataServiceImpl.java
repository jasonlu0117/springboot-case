package com.lym.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lym.dao.test2.DataJpaDao;
import com.lym.entity.test2.Data;
import com.lym.service.DataService;

@Service
@Transactional
public class DataServiceImpl implements DataService {

    @Autowired
    private DataJpaDao dataJpaDao;
    
    public List<Data> getDataByTypeAndGroup(int dataType, int groupId) {
        return dataJpaDao.getDataByTypeAndGroup(dataType, groupId);
    }
    
}
