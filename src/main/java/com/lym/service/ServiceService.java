package com.lym.service;

import java.util.List;

import com.lym.vo.bo.ServiceFilterBo;

public interface ServiceService {

	public List<com.lym.entity.test.Service> getServiceByOwnerId(String ownerId);
    
    public ServiceFilterBo getServiceByFilter(String ownerId, int dataType, int groupId);

}
