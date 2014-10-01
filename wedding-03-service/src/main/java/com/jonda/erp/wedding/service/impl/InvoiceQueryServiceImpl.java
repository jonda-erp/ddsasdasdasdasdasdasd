package com.jonda.erp.wedding.service.impl;

import com.jonda.common.dao.PageQueryDao;
import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.dto.invoice.InvoiceQueryParam;
import com.jonda.erp.wedding.dto.invoice.InvoiceQueryResult;
import com.jonda.erp.wedding.service.InvoiceQueryService;
import com.jonda.erp.wedding.service.OrderQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by rejoady on 2014/7/18.
 */
@Transactional
@Service("invoiceQueryService")
public class InvoiceQueryServiceImpl implements InvoiceQueryService {

    private static final Logger logger = LoggerFactory.getLogger(OrderQueryService.class);

    @Resource
    private PageQueryDao pageQueryDao;

    @Override
    public Page<InvoiceQueryResult> queryInvoice(InvoiceQueryParam param) {
        return pageQueryDao.query("com.jonda.erp.wedding.dao.invoice.InvoiceQueryDao.queryInvoice", param);
    }
}
