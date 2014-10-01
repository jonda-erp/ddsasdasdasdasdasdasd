package com.jonda.erp.wedding.biz.query.impl;

import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.biz.query.InvoiceQueryBiz;
import com.jonda.erp.wedding.domain.wedding.order.Invoice;
import com.jonda.erp.wedding.dto.invoice.InvoiceQueryParam;
import com.jonda.erp.wedding.dto.invoice.InvoiceQueryResult;
import com.jonda.erp.wedding.service.InvoiceQueryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rejoady on 2014/8/17.
 */
@Component("invoiceQueryBiz")
public class InvoiceQueryBizImpl implements InvoiceQueryBiz {

    @Resource
    private InvoiceQueryService invoiceQueryService;

    @Override
    public List<InvoiceQueryResult> getInvoiceByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            throw new RuntimeException("订单号不能为空");
        }
        InvoiceQueryParam param = new InvoiceQueryParam();
        param.setOrderNo(orderNo);
        param.setPageSize(9999);
        Page<InvoiceQueryResult> data = invoiceQueryService.queryInvoice(param);
        if (data == null || data.getData() == null) {
            return new ArrayList<InvoiceQueryResult>();
        }
        return data.getData();
    }
}
