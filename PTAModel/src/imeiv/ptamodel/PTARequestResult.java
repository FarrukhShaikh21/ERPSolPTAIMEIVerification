package imeiv.ptamodel;

import java.math.BigDecimal;

public class PTARequestResult {
    public PTARequestResult() {
        super();
    }
    
    public PTARequestResult(Integer status, Integer responseCode, String message,String serialNo,String color,Integer isAssembled) {
        this.status = status;
        this.responseCode = responseCode;
        this.message = message;
        this.serialNo=serialNo;
        this.color=color;
        this.isAssembled=isAssembled;
        
    }
    private Integer status ;
    private Integer responseCode;
    private String message;
    private String serialNo;
    private String color;
    private Integer isAssembled;


    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setIsAssembled(Integer isAssembled) {
        this.isAssembled = isAssembled;
    }

    public Integer getIsAssembled() {
        return isAssembled;
    }

}
