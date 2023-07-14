package imeiv.ptamodel;

import java.math.BigDecimal;

public class PTARequestResult {
    public PTARequestResult() {
        super();
    }
    
    public PTARequestResult(Integer status, Integer responseCode, String message) {
        this.status = status;
        this.responseCode = responseCode;
        this.message = message;
    }
    private Integer status ;
    private Integer responseCode;
    private String message;


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

}
