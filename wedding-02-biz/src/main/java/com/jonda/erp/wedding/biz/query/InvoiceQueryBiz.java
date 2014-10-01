package com.jonda.erp.wedding.biz.query;

import com.jonda.erp.wedding.dto.invoice.InvoiceQueryResult;

import java.util.List;

/**
 * Created by rejoady on 2014/8/17.
 */
public interface InvoiceQueryBiz {

    /**
     * 获取订单的所有发票
     *
     * @param orderNo
     * @return
     */
    public List<InvoiceQueryResult> getInvoiceByOrderNo(String orderNo);

}
