package com.lym.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lym.dao.ServiceJpaDao;
import com.lym.service.ServiceService;

@Service
@Transactional
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceJpaDao serviceJpaDao;
    
    public List<com.lym.entity.Service> getServiceByOwnerId(String ownerId) {
        return serviceJpaDao.getServiceByOwnerId(ownerId);
    }
    
}
