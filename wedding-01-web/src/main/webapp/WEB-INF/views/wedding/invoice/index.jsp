<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<head>
    <title>发票管理</title>
</head>

<body>
    <table id="invoiceTable" fit="true" class="easyui-datagrid"
           data-options="url:'${ctx}/invoice/ajax/query?orderNo=${orderNo}&_=${random}',fitColumns:true,singleSelect:true"
       toolbar='#invoiceToolbar' idField="id">
        <thead>
            <tr>
                <th data-options="field:'orderNo',width:150">订单编号</th>
                <th data-options="field:'brideName',width:90">新娘姓名</th>
                <th data-options="field:'brideTelephone',width:100">新娘电话</th>
                <th data-options="field:'bridegroomName',width:90">新娘姓名</th>
                <th data-options="field:'bridegroomTelephone',width:100">新娘电话</th>
                <th data-options="field:'weddingDate',width:100">婚庆日期</th>
                <th data-options="field:'userName',width:100">开票人</th>
                <th data-options="field:'type',width:60">类型</th>
                <th data-options="field:'amount',width:100">金额</th>
                <th data-options="field:'remark',width:120">摘要</th>
            </tr>
        </thead>
    </table>
    <div id="invoiceToolbar" style="padding:5px;height:auto">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="createInvoice('${ctx}/invoice/add', '${orderNo}')">开发票</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="deleteInvoice('${ctx}/invoice/ajax/delete', '${orderNo}')">删除发票</a>
    </div>

    <div id="createInvoice" class="easyui-dialog" closed="true"
         buttons="#createInvoice-buttons" style="width:400px;height:100px;padding: 5px;background: #fafafa;"></div>
    <div id="createInvoice-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitForm('invoiceAddForm','createInvoice','invoiceTable')">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#createInvoice').dialog('close')">关闭</a>
    </div>
</body>