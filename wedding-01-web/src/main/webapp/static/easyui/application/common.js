//表格查询
function query(formId, table) {
    var form = $("#" + formId)
    var str = form.serialize();
    var comment = encodeURI(str );
    comment = encodeURI(str);//注重要两次
    var url = $('#'+table).datagrid('options').url;
    url=url.split("?")[0];
    $('#'+table).datagrid('getPager').pagination({pageNumber: 1});
    $('#'+table).datagrid('options').url = url + "?" + comment;
    $('#'+table).datagrid("reload");
}

function reset(formId, table) {
    var form = $("#" + formId);
    var url = form.attr("action");
    $('#'+table).datagrid('options').url = url;
    $('#'+table).datagrid("reload");
    form[0].reset();
}

function submitForm(formId, dialogId, gridId) {
    var form = $("#" + formId)
    var url = form.attr("action");
    form.form('submit', {
        url: url,
        method:"POST",
        onSubmit: function () {
            return form.form('validate');
        },
        success: function (response) {
            //result为请求处理后的返回值
            var result =  eval('(' + response + ')');
            if (result.statusCode == '200') {
                $.messager.show({
                    title: '操作成功',
                    msg: result.message
                });
                $("#"+dialogId).dialog('close');
                $('#'+gridId).datagrid('reload');
            } else {
                $.messager.show({
                    title: '操作失败',
                    msg: result.message
                });
            }
        }
    });
}