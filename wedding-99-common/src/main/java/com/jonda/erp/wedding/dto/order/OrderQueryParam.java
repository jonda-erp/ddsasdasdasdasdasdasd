package com.jonda.erp.wedding.dto.order;

import com.jonda.common.dto.BasePageQueryParam;

import java.util.Date;

/**
 * Created by rejoady on 2014/8/8.
 */
public class OrderQueryParam extends BasePageQueryParam {

    // 新娘姓名
    private String brideName;
    // 新娘电话
    private String brideTelephone;
    // 新郎姓名
    private String bridegroomName;
    // 新郎电话
    private String bridegroomTelephone;
    // 婚庆日期
    private Date weddingDate;
    // 订单状态
    private String status;



}
