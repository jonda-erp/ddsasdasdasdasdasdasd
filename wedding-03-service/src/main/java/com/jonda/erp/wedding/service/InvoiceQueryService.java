package com.jonda.erp.wedding.service;

import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.domain.wedding.order.Invoice;
import com.jonda.erp.wedding.dto.invoice.InvoiceQueryParam;
import com.jonda.erp.wedding.dto.invoice.InvoiceQueryResult;
import com.jonda.erp.wedding.dto.order.OrderQueryParam;
import com.jonda.erp.wedding.dto.order.OrderQueryResult;

/**
 * Created by rejoady on 2014/7/18.
 */
public interface InvoiceQueryService {

    /**
     * 分页查询发票信息
     *
     * @param param
     * @return
     */
    public Page<InvoiceQueryResult> queryInvoice(InvoiceQueryParam param);

    /**
     *  加载发票实体
     *
     * @param id
     * @return
     */
    public Invoice load(Long id);
}
