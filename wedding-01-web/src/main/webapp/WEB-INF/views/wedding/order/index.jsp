<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<head>
    <title>订单管理</title>
    <script type="text/javascript" src="${ctx}/static/easyui/application/order/order.js"></script>
</head>

<body class="easyui-layout" fit="true">
    <div region="north" class="easyui-panel" title="查询条件">
        <form id="searchForm" action="${ctx}/order/ajax/query">
            <div class="searchitem">
                <label>姓名：</label>
                <input type="text" id="name" name="name" class="easyui-textbox" />
            </div>
            <div class="searchitem">
                <label>电话：</label>
                <input type="text" id="telephone" name="telephone" class="easyui-textbox" />
            </div>
            <div class="searchitem">
                <label>婚庆日期：</label>
                <input type="text" id="ssDate" name="ssDate" class="easyui-datebox"/> 至
                <input type="text" id="seDate" name="seDate" class="easyui-datebox"/>
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
                <a href="javascript:query('searchForm','table');" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>&nbsp;&nbsp;
                <a href="javascript:window.location.href='${ctx}/order/index';" class="easyui-linkbutton" data-options="iconCls:'icon-search'">重置</a>
            </div>
        </form>
    </div>
    <div region="center">
        <table id="table" region="center" fit="true" class="easyui-datagrid" title="客户订单管理"
               data-options="url:'${ctx}/order/ajax/query',fitColumns:true,singleSelect:true"
               toolbar='#toolbar' pagination="true" idField="orderId">
            <thead>
                <tr>
                    <th data-options="field:'orderId',width:130">订单编号</th>
                    <th data-options="field:'contractId',width:130">合同编号</th>
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
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="createOrder('${ctx}/order/add')">创建订单</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editOrder()">修改订单</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="deleteAdminUser()">查看详情</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="deleteAdminUser()">修改合同</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="deleteAdminUser()">发票管理</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="deleteAdminUser()">管理人员需求</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="deleteAdminUser()">管理道具需求</a>
    </div>

    <div id="createOrder" class="easyui-dialog" closed="true"
         buttons="#createOrder-buttons" style="width:400px;height:100px;padding: 5px;background: #fafafa;"></div>
    <div id="createOrder-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitForm('orderAddForm','createOrder','table')">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#createOrder').dialog('close')">关闭</a>
    </div>

    <div id="editOrder" class="easyui-dialog" closed="true" buttons="#editOrder-buttons" style="padding:10px 20px"></div>
    <div id="editOrder-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitForm('orderEditForm','editOrder','table')">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#editOrder').dialog('close')">关闭</a>
    </div>
</body>