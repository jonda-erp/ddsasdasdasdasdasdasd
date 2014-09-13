//表格查询
function query(formId, table) {
    var form = $("#" + formId)
    var str = form.serialize();
    var comment = encodeURI(str );
    comment = encodeURI(str);//注重要两次

    $('#'+table).datagrid('getPager').pagination({pageNumber: 1});
    $('#'+table).datagrid('options').url = '/order/query?' + comment
    $('#'+table).datagrid("reload");
}