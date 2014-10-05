package com.jonda.erp.wedding.service.impl;

import com.jonda.erp.wedding.dao.invoice.InvoiceManageDao;
import com.jonda.erp.wedding.domain.wedding.order.Invoice;
import com.jonda.erp.wedding.service.InvoiceManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/10/5.
 */
@Transactional
@Service("invoiceManageService")
public class InvoiceManageServiceImpl implements InvoiceManageService {

    @Resource
    private InvoiceManageDao invoiceManageDao;

    @Override
    public void createInvoice(Invoice invoice) {
        invoiceManageDao.addInvoice(invoice);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        invoiceManageDao.delete(invoice);
    }

}
