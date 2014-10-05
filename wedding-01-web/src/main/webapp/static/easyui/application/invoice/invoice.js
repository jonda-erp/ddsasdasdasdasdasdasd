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

    function deleteInvoice(remoteUrl, id) {
        var row = $('#invoiceTable').datagrid('getSelected');
        if (row) {
            $.messager.confirm('操作确认','您确定删除该发票?',function(r){
                if (r){
                    $.post(remoteUrl+'?id=' + row.id, function(response) {
                        var result =  eval('(' + response + ')');
                        //msgShow('系统提示', "删除发票成功!", 'info');
                        if (result.statusCode == '200') {
                            $.messager.show({
                                title: '操作成功',
                                msg: result.message
                            });
                            $('#invoiceTable').datagrid('reload');
                        } else {
                            $.messager.show({
                                title: '操作失败',
                                msg: result.message
                            });
                        }
                    })
                }
            });
        } else {
            $.messager.alert("提示", "请选择需要删除的发票 ！");
        }

    }