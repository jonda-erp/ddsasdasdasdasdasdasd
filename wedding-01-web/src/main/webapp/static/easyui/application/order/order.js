
    var url; //提交数据的路径
    var formId; //当天要提交的Form的编号
    var dialogId; //对话框的编号


    //编辑科室部分
    function editOrder() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $('#editOrder').dialog('open');
            $("#textDepartmentName").val(row.Name);
            $("#textDepartmentDes").val(row.Introduce);
            $("#hoistal").combobox('setValue', row.HosptialID);
            //   $('#edit').form('clear');

            url = 'ashx/DepartmentsManagerService.ashx?action=edit&id=' + row.ID;
            formId = "#edit";
            dialogId = "#editOrder";

        }
        else {
            $.messager.alert("提示", "您没有选中任何行！");
        }
    }

    //添加科室部分
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



    //  删除代码部分
    function deleteAdminUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm('删除提示', '确定要删除' + row.Name + '吗', function (r) {
                if (r) {
                    $.post('ashx/DepartmentsManagerService.ashx', { id: row.ID, action: 'delete' }, function (data, status) {

                        if (data == "ok") {
                            $('#dg').datagrid('reload');
                        } else {
                            $.messager.show({
                                title: 'Error',
                                msg: '删除该科室失败!'
                            });
                        }
                    });
                }
            });
        }
    }