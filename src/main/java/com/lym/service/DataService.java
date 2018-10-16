package com.lym.service;

import java.util.List;

import com.lym.entity.test2.Data;

public interface DataService {

    List<Data> getDataByTypeAndGroup(int dataType, int groupId);
    
}
