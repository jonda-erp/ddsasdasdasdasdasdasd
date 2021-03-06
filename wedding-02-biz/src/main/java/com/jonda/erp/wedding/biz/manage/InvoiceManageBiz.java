package com.jonda.erp.wedding.biz.manage;

import com.jonda.erp.wedding.domain.wedding.order.Invoice;

/**
 * Created by rejoady on 2014/8/17.
 */
public interface InvoiceManageBiz {

    /**
     * 开发票
     *
     * @param invoice
     */
    public void createInvoice(Invoice invoice);

    /**
     * 删除发票
     *
     * @param invoice
     */
    public void deleteInvoice(Invoice invoice);

}
