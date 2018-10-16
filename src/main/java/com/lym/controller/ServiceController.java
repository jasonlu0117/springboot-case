package com.lym.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lym.service.ServiceService;
import com.lym.util.CommonUtil;
import com.lym.util.constant.Constants;
import com.lym.vo.BaseVo;
import com.lym.vo.bo.ServiceFilterBo;

@RestController
public class ServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
    
    @Autowired
    private ServiceService serviceService;
    
    @RequestMapping("/service")
    public BaseVo getServiceByOwnerId(@RequestParam String ownerId, @RequestParam String dataType, @RequestParam String groupId) {
        if (CommonUtil.isEmpty(ownerId, dataType, groupId)) {
            return new BaseVo(Constants.FAILURE_CODE, Constants.FAILURE_STATUS, Constants.ERROR_LACK_PARAM);
        }
        
        ServiceFilterBo serviceFilterBo = serviceService.getServiceByFilter(ownerId, Integer.valueOf(dataType), Integer.valueOf(groupId));
        
        return new BaseVo(Constants.SUCCESS_CODE, Constants.SUCCESS_STATUS, serviceFilterBo);
    }
    
}
