package imeiv.ptamodel;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "VwItemImeiInformation.findAll", query = "select o from VwItemImeiInformation o"),
                @NamedQuery(name = "VwItemImeiInformation.findByIMEI", query = "select o from VwItemImeiInformation o where o.imei1=:pimei1 and o.imei2=:pimei2 and o.apikey=:papikey")})
@Table(name = "VW_ITEM_IMEI_INFORMATION")
public class VwItemImeiInformation implements Serializable {
    private static final long serialVersionUID = 2916143399965945574L;
    private String apikey;
    @Id
    @Column(nullable = false, length = 40)
    private String imei1;
    @Column(length = 40)
    private String imei2;
    private String message;
    @Column(name = "RESPONSE_CODE")
    private BigDecimal responseCode;
    private BigDecimal status;
    private String serialNo;
    private String color;
    private Integer isAssembled;

    public VwItemImeiInformation() {
    }

    public VwItemImeiInformation(String apikey, String imei1, String imei2, String message, BigDecimal responseCode,
                                 BigDecimal status,String serialNo,String color,Integer isAssembled) {
        this.apikey = apikey;
        this.imei1 = imei1;
        this.imei2 = imei2;
        this.message = message;
        this.responseCode = responseCode;
        this.status = status;
        this.serialNo=serialNo;
        this.color=color;
        this.isAssembled=isAssembled;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getImei1() {
        return imei1;
    }

    public void setImei1(String imei1) {
        this.imei1 = imei1;
    }

    public String getImei2() {
        return imei2;
    }

    public void setImei2(String imei2) {
        this.imei2 = imei2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(BigDecimal responseCode) {
        this.responseCode = responseCode;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
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
