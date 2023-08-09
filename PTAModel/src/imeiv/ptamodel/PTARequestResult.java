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
        this.serial_no=serialNo;
        this.color=color;
        this.is_assembled=isAssembled;
        
    }
    private Integer status ;
    private Integer responseCode;
    private String message;
    private String serial_no;
    private String color;
    private Integer is_assembled;

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setIs_assembled(Integer is_assembled) {
        this.is_assembled = is_assembled;
    }

    public Integer getIs_assembled() {
        return is_assembled;
    }


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

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }


}
