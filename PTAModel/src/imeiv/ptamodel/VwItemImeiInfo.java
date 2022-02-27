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
@NamedQueries({ @NamedQuery(name = "VwItemImeiInfo.findAll", query = "select o from VwItemImeiInfo o") })
@Table(name = "VW_ITEM_IMEI_INFO")
public class VwItemImeiInfo implements Serializable {
    private static final long serialVersionUID = 2714985546330581722L;
    private String message;
    @Column(name = "RESPONSE_CODE")
    private BigDecimal responseCode;
    @Id
    @Column(nullable = false)
    private BigDecimal status;

    public VwItemImeiInfo() {
    }

    public VwItemImeiInfo(String message, BigDecimal responseCode, BigDecimal status) {
        this.message = message;
        this.responseCode = responseCode;
        this.status = status;
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
