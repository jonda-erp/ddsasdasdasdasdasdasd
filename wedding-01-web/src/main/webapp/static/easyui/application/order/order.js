
    var url; //提交数据的路径
    var formId; //当天要提交的Form的编号
    var dialogId; //对话框的编号

    var successCallback = function (result) {
        //result为请求处理后的返回值
        var result = eval('(' + result + ')');
        if (result.success) {
            $.messager.show({
                title: 'Success',
                msg: result.msg
            });
            $(dialogId).dialog('close');
            $('#dg').datagrid('reload');
        } else {
            $.messager.show({
                title: 'Error',
                msg: result.msg
            });
        }
    }
    //编辑科室部分
    function editDepartmentInfo() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $('#editDepartmentInfo').dialog('open');
            $("#textDepartmentName").val(row.Name);
            $("#textDepartmentDes").val(row.Introduce);
            $("#hoistal").combobox('setValue', row.HosptialID);
            //   $('#edit').form('clear');

            url = 'ashx/DepartmentsManagerService.ashx?action=edit&id=' + row.ID;
            formId = "#edit";
            dialogId = "#editDepartmentInfo";

        }
        else {
            $.messager.alert("提示", "您没有选中任何行！");
        }
    }

    //添加科室部分
    function addDepartmentInfo(remoteUrl) {
        $("#addDepartmentInfo").dialog({
            "title": "新建科室信息",
            width: 500,
            height: 450,
            href: remoteUrl
        });
        $('#addDepartmentInfo').dialog('open');
        $('#add').form('clear');

        url = 'ashx/DepartmentsManagerService.ashx?action=add';
        formId = "#add";
        dialogId = "#addDepartmentInfo";
    }
    function saveInfo() {

        $(formId).form('submit', {
            url: url,
            onSubmit: function () {
                alert(formId);
                return $(this).form('validate');
            },
            success: successCallback
        });
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

    //多条件查询方法
    function query() {
        //var name = $("#name").combobox("getValue");
        var name = $("#name").val();
        var telephone = $("#telephone").val();
        var ssDate = $("#ssDate").val();
        var seDate = $("#seDate").val();
        var status = $("#status").val();

        //$('#dg').datagrid('options').pageNumber = 1;
        $('#table').datagrid('getPager').pagination({pageNumber: 1});
        $('#table').datagrid('options').url = '/order/query?' +
            'name='+name+'&telephone='+telephone+'&ssDate='+ssDate+'&seDate='+seDate+'&status='+status;
        $('#table').datagrid("reload");
    }