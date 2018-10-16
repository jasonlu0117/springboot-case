package com.lym.vo.bo;

import java.util.List;

import com.lym.entity.test.Service;

public class ServiceFilterBo {

    List<Service> savedList;
    List<Service> unsavedList;
    
    public List<Service> getSavedList() {
        return savedList;
    }
    public void setSavedList(List<Service> savedList) {
        this.savedList = savedList;
    }
    public List<Service> getUnsavedList() {
        return unsavedList;
    }
    public void setUnsavedList(List<Service> unsavedList) {
        this.unsavedList = unsavedList;
    }
    
}
