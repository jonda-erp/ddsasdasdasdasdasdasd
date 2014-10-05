package com.jonda.erp.wedding.dao.invoice;

import com.jonda.common.dao.MyBatisRepository;
import com.jonda.common.dto.Page;
import com.jonda.erp.wedding.domain.wedding.order.Invoice;
import com.jonda.erp.wedding.dto.invoice.InvoiceQueryParam;
import com.jonda.erp.wedding.dto.invoice.InvoiceQueryResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by rejoady on 2014/8/17.
 */
@MyBatisRepository
public interface InvoiceQueryDao {

    public Invoice load(@Param("id")Long id);

}
