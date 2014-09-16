<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>婚庆企业管理平台</title>
    <script>
        function busiOutByConId() {
            var row = $('#dataList').datagrid('getSelected');
            if (row){
                var remoteUrl = "${ctx}/stock/busiOutByContract";
                $("#busiOutByConId").dialog({
                    "title": "合同出库",
                    toolbar: '#busiOutByConId',
                    buttons: '#busiOutByConId-buttons',
                    href:remoteUrl
                });
                $('#busiOutByConId').dialog('open');
            }
        }
    </script>
</head>
<body class="easyui-layout" fit="true">
<div region="north" class="easyui-panel" title="查询条件">
    <form id="searchForm" action="${ctx}/order/query">
        <div class="searchitem">
            <label>姓名：</label>
            <input type="text" id="name" name="name" class="easyui-validatebox" />
        </div>
        <div class="searchitem">
            <label>电话：</label>
            <input type="text" id="telephone" name="telephone" class="easyui-validatebox" />
        </div>
        <div class="searchitem">
            <label>婚庆日期：</label>
            <input type="text" id="ssDate" name="ssDate" class="easyui-datebox" /> 至
            <input type="text" id="seDate" name="seDate" class="easyui-datebox" />
        </div>
        <div class="searchitem">
            <label>订单状态：</label>
            <select class="easyui-combobox" id="status" name="status" style="width:100px;">
                <option value="">全部</option>
                <c:forEach var="item" items="${orderStatusEnum}">
                    <option value="${item.code}">${item.message}</option>
                </c:forEach>
            </select>
        </div>
        <div class="searchitem">
            <a href="javascript:query('searchForm','table')" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>&nbsp;&nbsp;
            <a href="javascript:window.location.reload();" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
        </div>
    </form>
</div>
<div region="center">
    <table id="dataList" region="center" fit="true" class="easyui-datagrid" title="客户订单管理"
           data-options="url:'${ctx}/order/ajax/query',fitColumns:true,singleSelect:true"
           toolbar='#toolbar' pagination="true" idField="orderId">
        <thead>
        <tr>
            <th data-options="field:'orderId',width:100">订单编号</th>
            <th data-options="field:'contractId',width:100">合同编号</th>
            <th data-options="field:'brideName',width:100">新娘姓名</th>
            <th data-options="field:'brideTelephone',width:100">新娘电话</th>
            <th data-options="field:'bridegroomName',width:100">新娘姓名</th>
            <th data-options="field:'bridegroomTelephone',width:100">新娘电话</th>
            <th data-options="field:'weddingDate',width:100">婚庆日期</th>
            <th data-options="field:'status',width:100">状态</th>
            <th data-options="field:'remark',width:100">备注</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar" style="padding:5px;height:auto">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="busiOutByConId()">订单合同出库</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editOrder()">订单额外出库</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="deleteAdminUser()">查看出库详情</a>
</div>

<div id="busiOutByConId" class="easyui-dialog" closed="true" style="width:600px;height:400px;top:100px;padding:5px;background: #fafafa;">

</div>
<div id="busiOutByConId-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveInfo()">提交</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#busiOutByConId').dialog('close')">关闭</a>
</div>
</body>