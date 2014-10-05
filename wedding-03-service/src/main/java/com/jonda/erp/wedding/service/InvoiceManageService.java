package com.jonda.erp.wedding.service;

import com.jonda.erp.wedding.domain.wedding.order.Invoice;

/**
 * Created by rejoady on 2014/10/5.
 */
public interface InvoiceManageService {

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
