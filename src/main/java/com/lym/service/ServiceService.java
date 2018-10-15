package com.lym.service;

import java.util.List;

import com.lym.entity.Service;

public interface ServiceService {

    List<Service> getServiceByOwnerId(String ownerId);
    
}
