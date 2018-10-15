package com.lym.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lym.util.constant.Constants;
import com.lym.vo.BaseVo;

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(Exception.class)
    public BaseVo normalException(Exception e) {
        logger.error("exception handler");
        BaseVo baseVo = new BaseVo();
        baseVo.setCode(400);
        baseVo.setStatus(Constants.FAILURE_STATUS);
        baseVo.setMessage(e.toString());
        baseVo.setResult(null);
        return baseVo;
    }
    
}
