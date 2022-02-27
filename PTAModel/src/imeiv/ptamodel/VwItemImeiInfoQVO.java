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
@NamedQueries({ @NamedQuery(name = "VwItemImeiInfoQVO.findAll", query = "select o from VwItemImeiInfoQVO o"),
                @NamedQuery(name = "VwItemImeiInfoQVO.findByImei", query = "select o from VwItemImeiInfoQVO o where o.imei1=:pimei1 and o.imei2=:pimei2 and :papikey='D$pL0y@cC$sSk$y'")})
@Table(name = "VW_ITEM_IMEI_INFO")
public class VwItemImeiInfoQVO implements Serializable {
    private static final long serialVersionUID = 54207459051423466L;
    private BigDecimal imei1;
    private BigDecimal imei2;
    private String message;
    @Column(name = "RESPONSE_CODE")
    private BigDecimal responseCode;
    @Id
    @Column(nullable = false)
    private BigDecimal status;

    public VwItemImeiInfoQVO() {
    }

    public VwItemImeiInfoQVO(BigDecimal imei1, BigDecimal imei2, String message, BigDecimal responseCode,
                             BigDecimal status) {
        this.imei1 = imei1;
        this.imei2 = imei2;
        this.message = message;
        this.responseCode = responseCode;
        this.status = status;
    }

    public BigDecimal getImei1() {
        return imei1;
    }

    public void setImei1(BigDecimal imei1) {
        this.imei1 = imei1;
    }

    public BigDecimal getImei2() {
        return imei2;
    }

    public void setImei2(BigDecimal imei2) {
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
}
