package com.lym.vo;

public class BaseVo {
    
    private int code;
    private String status;
    private String message;
    private Object result;
    
    public BaseVo() {
    }
    
    public BaseVo(int code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
    
    public BaseVo(int code, String status, Object result) {
        this.code = code;
        this.status = status;
        this.result = result;
    }
    
    public BaseVo(int code, String status, String message, Object result) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.result = result;
    }
    
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }

}
