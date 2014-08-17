package com.jonda.erp.wedding.biz.query;

import com.jonda.erp.wedding.domain.wedding.order.Invoice;

import java.util.List;

/**
 * Created by rejoady on 2014/8/17.
 */
public interface InvoiceQueryBiz {

    /**
     * 获取订单的所有发票
     *
     * @param orderId
     * @return
     */
    public List<Invoice> getInvoiceByOrderId(Long orderId);

}
