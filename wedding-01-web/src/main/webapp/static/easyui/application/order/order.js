    /**
     * 创建订单
     *
     * @param remoteUrl
     */
    function createOrder(remoteUrl) {
        $("#createOrder").dialog({
            "title": "创建订单",
            width: 500,
            height: 480,
            top:100,
            left:250,
            href: remoteUrl
        });
        $('#createOrder').dialog('open');
        $('#createOrder').form('clear');
    }

    /**
     * 修改订单内容
     *
     * @param remoteUrl
     */
    function editOrder(remoteUrl) {
        var row = $('#table').datagrid('getSelected');
        if (row) {
            $("#editOrder").dialog({
                "title": "修改订单",
                width: 500,
                height: 480,
                top:100,
                left:250,
                href: remoteUrl + '?orderNo=' + row.orderNo
            });
            $('#editOrder').dialog('open');
        } else {
            $.messager.alert("提示", "您没有选中任何行！");
        }
    }

    /**
     * 查看订单详情
     *
     * @param remoteUrl
     */
    function showDetail(remoteUrl) {
        var row = $('#table').datagrid('getSelected');
        if (row) {
            $("#detail").dialog({
                "title": "订单详情",
                width: 500,
                height: 480,
                top:100,
                left:250,
                href: remoteUrl + '?orderNo=' + row.orderNo
            });
            $('#detail').dialog('open');
        } else {
            $.messager.alert("提示", "您没有选中任何行！");
        }
    }