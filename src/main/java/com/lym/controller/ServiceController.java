package com.lym.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lym.entity.Service;
import com.lym.service.ServiceService;
import com.lym.util.CommonUtil;
import com.lym.util.constant.Constants;
import com.lym.vo.BaseVo;

@RestController
public class ServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
    
    @Autowired
    private ServiceService serviceService;
    
    @RequestMapping("/service")
    public BaseVo getServiceByOwnerId(@RequestParam String ownerId) {
        if (CommonUtil.isEmpty(ownerId)) {
            return new BaseVo(Constants.FAILURE_CODE, Constants.FAILURE_STATUS, Constants.ERROR_LACK_PARAM);
        }
        
        List<Service> serviceList = serviceService.getServiceByOwnerId(ownerId);
        
        return new BaseVo(Constants.SUCCESS_CODE, Constants.SUCCESS_STATUS, serviceList);
    }
    
}
