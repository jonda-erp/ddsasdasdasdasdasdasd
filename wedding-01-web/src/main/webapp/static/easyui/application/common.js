//表格查询
function query(formId, table) {
    var form = $("#" + formId)
    var str = form.serialize();
    var comment = encodeURI(str );
    comment = encodeURI(str);//注重要两次
    var url = form.attr("action");
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