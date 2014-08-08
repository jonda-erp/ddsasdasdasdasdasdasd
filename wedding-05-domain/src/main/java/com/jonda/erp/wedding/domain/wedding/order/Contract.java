package com.jonda.erp.wedding.domain.wedding.order;

import com.jonda.common.domain.BaseDomain;

import java.util.List;

/**
 * 合同
 *
 * Created by rejoady on 2014/8/6.
 */
public class Contract extends BaseDomain {
    // 合同编号
    private String contractNo;
    // 合同内容
    private String content;
    // 订单
    private Order order;
    // 道具需求列表
    private List<ProductUse> productUses;
    // 人员需求
    private List<WorkerRequired> workerRequireds;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<ProductUse> getProductUses() {
        return productUses;
    }

    public void setProductUses(List<ProductUse> productUses) {
        this.productUses = productUses;
    }

    public List<WorkerRequired> getWorkerRequireds() {
        return workerRequireds;
    }

    public void setWorkerRequireds(List<WorkerRequired> workerRequireds) {
        this.workerRequireds = workerRequireds;
    }
}
