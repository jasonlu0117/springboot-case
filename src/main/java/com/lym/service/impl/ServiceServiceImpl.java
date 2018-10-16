package com.lym.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lym.dao.test.ServiceJpaDao;
import com.lym.dao.test2.DataJpaDao;
import com.lym.entity.test2.Data;
import com.lym.service.ServiceService;
import com.lym.vo.bo.ServiceFilterBo;

@Service
@Transactional
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceJpaDao serviceJpaDao;
    
    @Autowired
    private DataJpaDao dataJpaDao;
    
    public List<com.lym.entity.test.Service> getServiceByOwnerId(String ownerId) {
        return serviceJpaDao.getServiceByOwnerId(ownerId);
    }
    
    public ServiceFilterBo getServiceByFilter(String ownerId, int dataType, int groupId) {
        List<com.lym.entity.test.Service> serviceList = serviceJpaDao.getServiceByOwnerId(ownerId);
        List<Data> dataList = dataJpaDao.getDataByTypeAndGroup(dataType, groupId);
        
        List<com.lym.entity.test.Service> savedList = Lists.newArrayList();
        List<com.lym.entity.test.Service> unsavedList = Lists.newArrayList();
        ServiceFilterBo serviceFilterBo = new ServiceFilterBo();
        
        if (dataList == null || dataList.size() < 1) {
            serviceFilterBo.setUnsavedList(serviceList);
            return serviceFilterBo;
        }
        
        for (int i = 0; i < serviceList.size(); i++) {
            for (int j = 0; j < dataList.size(); j++) {
                if (serviceList.get(i).getSid().equals(dataList.get(j).getSid())) {
                    savedList.add(serviceList.get(i));
                } else {
                    unsavedList.add(serviceList.get(i));
                }
            }
        }
        
        serviceFilterBo.setSavedList(savedList);
        serviceFilterBo.setUnsavedList(unsavedList);
        return serviceFilterBo;
    }
    
}
