package com.jonda.erp.wedding.domain.wedding.order;

import com.jonda.common.domain.BaseDomain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 订单
 *
 * Created by rejoady on 2014/8/6.
 */
public class Order extends BaseDomain {
    // 新娘姓名
    private String brideName;
    // 新娘电话
    @NotNull(message = "新娘电话不能为空")
    @Min(value = 1,message = "新娘电话不能为空")
    private String brideTelephone;
    // 新郎姓名
    private String bridegroomName;
    // 新郎电话
    private String bridegroomTelephone;
    // 婚庆日期
    @NotNull(message = "婚庆日期不能为空")
    private Date weddingDate;
    // 订单状态
    private String status;
    // 备注
    private String remark;
    // 订单对应的合同
    private Contract contract;
    // 订单对应开具的发票
    private List<Invoice> invoices;

    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    public String getBrideTelephone() {
        return brideTelephone;
    }

    public void setBrideTelephone(String brideTelephone) {
        this.brideTelephone = brideTelephone;
    }

    public String getBridegroomName() {
        return bridegroomName;
    }

    public void setBridegroomName(String bridegroomName) {
        this.bridegroomName = bridegroomName;
    }

    public String getBridegroomTelephone() {
        return bridegroomTelephone;
    }

    public void setBridegroomTelephone(String bridegroomTelephone) {
        this.bridegroomTelephone = bridegroomTelephone;
    }

    public Date getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
