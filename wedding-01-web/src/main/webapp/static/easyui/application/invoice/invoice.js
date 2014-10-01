    /**
     * 创建订单
     *
     * @param remoteUrl
     */
    function createInvoice(remoteUrl, orderNo) {
        $("#createInvoice").dialog({
            "title": "开发票",
            width: 500,
            height: 480,
            top:100,
            left:250,
            href: remoteUrl + '?orderNo=' + orderNo
        });
        $('#createInvoice').dialog('open');
    }